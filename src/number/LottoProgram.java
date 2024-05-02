package number;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import GUI.Function;
import GUI.LottoGUI;

public class LottoProgram {
	private List<UserLotto> lottoes;
	private List<UserLotto> winLottoes;
	private DrawLotto drawLotto;
	private Set<Integer> drawSet;
	private int bonusNumber;
	private JPanel resultTotalListPnl;
	private JPanel resultWinListPnl;
	private CardLayout cl_resultDisplayPnl;
	private JPanel resultDisplayPnl;
	private JButton resultSummuryBtn;
	private List<JPanel> pnlList;
	private LottoGUI gui;
	private JPanel listTotalPnl;

	public LottoProgram(LottoGUI gui) {
		this.lottoes = new ArrayList<>();
		this.winLottoes = new ArrayList<>();
		this.drawSet = new TreeSet<>();
		this.resultTotalListPnl = gui.getResultTotalListPnl();
		this.resultWinListPnl = gui.getResultWinListPnl();
		this.cl_resultDisplayPnl = gui.getCl_resultDisplayPnl();
		this.resultDisplayPnl = gui.getResultDisplayPnl();
		this.resultSummuryBtn = gui.getResultSummuryBtn();
		this.pnlList = new ArrayList<>();
		this.gui = gui;
		this.listTotalPnl = gui.getListTotalPnl();
	}

	/**
	 * 정수 6개를 받아 정수들이 중복된 값을 갖는지, 1~45 이외의 값을 갖는지 검사하는 메소드
	 * 
	 * @param i1 첫번째 정수
	 * @param i2 두번째 정수
	 * @param i3 세번째 정수
	 * @param i4 네번째 정수
	 * @param i5 다섯번째 정수
	 * @param i6 여섯번째 정수
	 * @return 정상적으로 생성이 가능한경우, 1을 리턴함<br>
	 *         중복되는 숫자가 존재할 경우, 0을 리턴함<br>
	 *         범위를 벗어나는 숫자가 입력된 경우, -1을 리턴함
	 */
	public int isCreatable(int i1, int i2, int i3, int i4, int i5, int i6) {
		int[] intArr = new int[6];
		intArr[0] = i1;
		intArr[1] = i2;
		intArr[2] = i3;
		intArr[3] = i4;
		intArr[4] = i5;
		intArr[5] = i6;
		for (int i = 0; i < intArr.length; i++) {
			int target = intArr[i];
			if (target > 45 || target < 0) {
				return -1;
			}
			for (int j = i + 1; j < intArr.length; j++) {
				if (target == intArr[j]) {
					return 0;
				}
			}
		}
		return 1;
	}

	/**
	 * * 정수 6개를 받아 로또 번호로 쓸 정수 묶음을 만드는 메소드.<br>
	 * 만들어진 정수 묶음은 LottoProgram에 저장된다.<br>
	 * 자동으로 오름차순 정렬되며, 중복된 숫자가 존재하거나, 1 ~ 45 사이의 정수가 아니라면 생성에 실패함.
	 * 
	 * @param i1 첫번째 정수
	 * @param i2 두번째 정수
	 * @param i3 세번째 정수
	 * @param i4 네번째 정수
	 * @param i5 다섯번째 정수
	 * @param i6 여섯번째 정수
	 */
	public void addUserLotto(int i1, int i2, int i3, int i4, int i5, int i6) {
		if (isCreatable(i1, i2, i3, i4, i5, i6) == 1) {
			UserLotto temp = new UserLotto(i1, i2, i3, i4, i5, i6);
			lottoes.add(temp);
		} else if (isCreatable(i1, i2, i3, i4, i5, i6) == 0) {
			// 중복되는 정수가 존재함
		} else if (isCreatable(i1, i2, i3, i4, i5, i6) == -1) {
			// 정상적인 범위의 정수가 아님
		}
	}

	/**
	 * UserLotto라는 정수 묶음을 받아서 당첨 결과를 조회하는 메소드.<br>
	 * LottoProgram에 당첨 결과인 drawLotto와 대조하여 당첨 결과를 리턴한다.
	 * 
	 * @param userLotto
	 * @return -1일 경우, 꽝<br>
	 *         -1이외의 정수는 당첨 등수를 의미한다.
	 */
	public int correctNumber(UserLotto userLotto) {
		int result = 0;
		for (Integer iUser : userLotto.getIntSet()) {
			for (Integer iDraw : this.drawLotto.getIntSet()) {
				if (iDraw == iUser) {
					result++;
				}
			}
		}
		if (result == 6) {
			return 1;
		}
		if (result == 5 && userLotto.getIntSet().contains(this.bonusNumber)) {
			return 2;
		}
		switch (result) {
		case 3:
			return 5;
		case 4:
			return 4;
		case 5:
			return 3;
		}
		return -1;
	}

	/**
	 * 당첨 로또번호를 하나씩 랜덤으로 뽑아내서, Set으로 저장해두는 메소드<br>
	 * Set값으로 당첨로또를 만들어서 활용할 예정, 보너스 넘버도 필드에 저장해둠.
	 * 
	 * @return 랜덤 로또번호가 리턴됨.
	 */
	public int makeDrawLotto() {
		Random rand = new Random();
		int randNum = -1;
		if (this.bonusNumber != 0) {
			return -1;
		}
		while (drawSet.size() <= 6) {
			randNum = rand.nextInt(45) + 1;
			if (drawSet.size() != 6) {
				if (!this.drawSet.contains(randNum)) {
					drawSet.add(randNum);
					break;
				}
			} else {
				if (!this.drawSet.contains(randNum)) {
					this.bonusNumber = randNum;
					drawResult();
					break;
				}
			}
		}
		return randNum;
	}

	/**
	 * UserLotto를 입력받아 UserLotto에 맞는 로또 패널을 생성해주는 메소드
	 */
	public JPanel makeLottoPanel(UserLotto userLotto) {
		JPanel pnl = new JPanel();
		pnl.setPreferredSize(new Dimension(500, 70));
		pnl.setLayout(null);

		JLabel lbl1 = new JLabel();
		JLabel lbl2 = new JLabel();
		JLabel lbl3 = new JLabel();
		JLabel lbl4 = new JLabel();
		JLabel lbl5 = new JLabel();
		JLabel lbl6 = new JLabel();

		lbl1.setSize(37, 37);
		lbl2.setSize(37, 37);
		lbl3.setSize(37, 37);
		lbl4.setSize(37, 37);
		lbl5.setSize(37, 37);
		lbl6.setSize(37, 37);

		lbl1.setLocation(44, 20);
		lbl2.setLocation(111, 20);
		lbl3.setLocation(178, 20);
		lbl4.setLocation(245, 20);
		lbl5.setLocation(312, 20);
		lbl6.setLocation(379, 20);

		lbl1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl2.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl3.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl4.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl5.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl6.setHorizontalTextPosition(SwingConstants.CENTER);

		List<JLabel> lblList = new ArrayList<>();
		lblList.add(lbl1);
		lblList.add(lbl2);
		lblList.add(lbl3);
		lblList.add(lbl4);
		lblList.add(lbl5);
		lblList.add(lbl6);

		int index = 0;
		for (Integer i : userLotto.getIntSet()) {
			if (this.drawLotto != null) {
				int rank = correctNumber(userLotto);
				if (index < 6 && this.drawLotto.getIntSet().contains(i)) {
					lblList.get(index).setSize(41, 41);
					lblList.get(index).setLocation((int) lblList.get(index).getLocation().getX() - 2, 18);
					if (i >= 41) {
						lblList.get(index).setBorder(new LineBorder(Color.GREEN, 2));
					} else if (i >= 31) {
						lblList.get(index).setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
					} else if (i >= 21) {
						lblList.get(index).setBorder(new LineBorder(Color.RED, 2));
					} else if (i >= 11) {
						lblList.get(index).setBorder(new LineBorder(Color.CYAN, 2));
					} else {
						lblList.get(index).setBorder(new LineBorder(new Color(189, 183, 107), 2));
					}
				}
				if (rank == 2) {
					if (index < 6 && this.drawLotto.getBonusNumber() == i) {
						lblList.get(index).setSize(41, 41);
						lblList.get(index).setLocation((int) lblList.get(index).getLocation().getX() - 2, 18);
						if (i >= 41) {
							lblList.get(index).setBorder(new LineBorder(Color.GREEN, 2));
						} else if (i >= 31) {
							lblList.get(index).setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
						} else if (i >= 21) {
							lblList.get(index).setBorder(new LineBorder(Color.RED, 2));
						} else if (i >= 11) {
							lblList.get(index).setBorder(new LineBorder(Color.CYAN, 2));
						} else {
							lblList.get(index).setBorder(new LineBorder(new Color(189, 183, 107), 2));
						}
					}
				}
			}
			String fileName = "/GUI/lottoNumbers/" + i.toString() + ".png";
			URL imgUrl = Function.class.getResource(fileName);
			lblList.get(index).setIcon(new ImageIcon(imgUrl));
			index++;
		}
		JLabel lbl7 = new JLabel();
		lbl7.setSize(50, 37);
		lbl7.setLocation(446, 20);
		lbl7.setHorizontalTextPosition(SwingConstants.CENTER);
		if (this.drawLotto != null) {
			int rankNum = correctNumber(userLotto);
			String rankText = "";
			if (rankNum != -1) {
				rankText += "/GUI/lottoNumbers/" + rankNum + "등.png";
			} else {
				rankText = "/GUI/lottoNumbers/" + rankNum + "등.png";
			}
			URL imgUrl = Function.class.getResource(rankText);
			lbl7.setIcon(new ImageIcon(imgUrl));
			pnl.add(lbl7);
		} else {
			pnl.add(lbl7);
		}
		pnl.add(lbl1);
		pnl.add(lbl2);
		pnl.add(lbl3);
		pnl.add(lbl4);
		pnl.add(lbl5);
		pnl.add(lbl6);

		pnl.setBackground(Color.WHITE);

		pnl.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		pnlList.add(pnl);

		return pnl;
	}

	/**
	 * 줄맞춤을 위해서 빈 로또를 생성하는 메소드
	 */
	public JPanel makeEmptyLotto() {
		JPanel pnl = new JPanel();
		pnl.setPreferredSize(new Dimension(500, 70));
		pnl.setLayout(null);

		JLabel lbl1 = new JLabel();
		JLabel lbl2 = new JLabel();
		JLabel lbl3 = new JLabel();
		JLabel lbl4 = new JLabel();
		JLabel lbl5 = new JLabel();
		JLabel lbl6 = new JLabel();
		JLabel lbl7 = new JLabel();

		lbl1.setSize(37, 37);
		lbl2.setSize(37, 37);
		lbl3.setSize(37, 37);
		lbl4.setSize(37, 37);
		lbl5.setSize(37, 37);
		lbl6.setSize(37, 37);
		lbl7.setSize(50, 37);

		lbl1.setLocation(44, 20);
		lbl2.setLocation(111, 20);
		lbl3.setLocation(178, 20);
		lbl4.setLocation(245, 20);
		lbl5.setLocation(312, 20);
		lbl6.setLocation(379, 20);
		lbl7.setLocation(446, 20);

		lbl1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl2.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl3.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl4.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl5.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl6.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl7.setHorizontalTextPosition(SwingConstants.CENTER);

		pnl.setBackground(Color.WHITE);

		return pnl;
	}

	/**
	 * 전체 구매로또들을 구매 내역 패널에 표시하는 메소드
	 */
	public void printPurchaseLotto() {
		this.listTotalPnl = gui.getListTotalPnl();
		if (lottoes.size() < 7) {
			int count = 7 - lottoes.size();
			for (UserLotto uL : lottoes) {
				this.listTotalPnl.add(makeLottoPanel(uL));
			}
			for (int i = 1; i <= count; i++) {
				this.listTotalPnl.add(makeEmptyLotto());
			}
		} else {
			for (UserLotto uL : lottoes) {
				this.listTotalPnl.add(makeLottoPanel(uL));
			}
		}
	}

	/**
	 * 전체 구매로또들을 추첨 결과 패널에 표시하는 메소드
	 */
	public void printAllUserLotto() {
		this.resultTotalListPnl = gui.getResultTotalListPnl();
		if (lottoes.size() > 5) {
			for (UserLotto uL : lottoes) {
				this.resultTotalListPnl.add(makeLottoPanel(uL));
			}
		} else {
			int count = 5 - lottoes.size();
			for (UserLotto uL : lottoes) {
				this.resultTotalListPnl.add(makeLottoPanel(uL));
			}
			for (int i = 1; i <= count; i++) {
				this.resultTotalListPnl.add(makeEmptyLotto());
			}
		}
	}

	/**
	 * 당첨된 로또들을 추첨 결과 패널에 표시하는 메소드
	 */
	public void printWinLotto() {
		this.resultWinListPnl = gui.getResultWinListPnl();
		if (winLottoes.size() > 5) {
			for (UserLotto uL : winLottoes) {
				this.resultWinListPnl.add(makeLottoPanel(uL));
			}
		} else {
			int count = 5 - winLottoes.size();
			for (UserLotto uL : winLottoes) {
				this.resultWinListPnl.add(makeLottoPanel(uL));
			}
			for (int i = 1; i <= count; i++) {
				this.resultWinListPnl.add(makeEmptyLotto());
			}
		}
	}

	/**
	 * 패널에 표시된 로또들을 정리(청소)하는 메소드
	 */
	public void pnlClear() {
		for (JPanel pnl : pnlList) {
			pnl.setSize(0, 0);
			pnl.setVisible(false);
		}
		pnlList.clear();
	}

	/**
	 * 추첨이 완전히 종료되었을때, 모든 필드를 초기화하는 메소드<br>
	 * 회차를 넘길때 사용해야함.
	 */
	public void endDrawLotto() {
		this.drawSet.clear();
		this.lottoes.clear();
		this.winLottoes.clear();
		this.drawLotto = null;
		this.bonusNumber = 0;
		pnlClear();
	}

	/**
	 * 당첨로또 생성이 끝나면, 당첨된 로또들의 목록을 만들고<br>
	 * 전체 로또들을 라벨로 생성해 패널에 넣어주는 메소드
	 */
	public void drawResult() {
		this.resultDisplayPnl = this.gui.getResultDisplayPnl();
		this.cl_resultDisplayPnl = this.gui.getCl_resultDisplayPnl();
		TreeSet<Integer> tempSet = new TreeSet<>();
		for (Integer i : drawSet) {
			tempSet.add(i);
		}
		int i1 = tempSet.pollFirst();
		int i2 = tempSet.pollFirst();
		int i3 = tempSet.pollFirst();
		int i4 = tempSet.pollFirst();
		int i5 = tempSet.pollFirst();
		int i6 = tempSet.pollFirst();
		int i7 = this.bonusNumber;
		
		Function function = this.gui.getFunction();
		
		Set<Integer> rank1Set = new TreeSet<>();
		rank1Set.add(i1);
		rank1Set.add(i2);
		rank1Set.add(i3);
		rank1Set.add(i4);
		rank1Set.add(i5);
		rank1Set.add(i6);
		Set<Integer> rank2Set = new TreeSet<>();
		rank2Set.add(i1);
		rank2Set.add(i2);
		rank2Set.add(i3);
		rank2Set.add(i4);
		rank2Set.add(i5);
		rank2Set.add(i7);
		function.setIntSet(rank1Set);
		function.confirmLotto();
		function.purchaseLotto();
		function.setIntSet(rank2Set);
		function.confirmLotto();
		function.purchaseLotto();
		
		this.drawLotto = new DrawLotto(i1, i2, i3, i4, i5, i6, i7);
		for (UserLotto uL : this.lottoes) {
			int result = correctNumber(uL);
			if (result != -1) {
				this.winLottoes.add(uL);
			}
		}
		this.cl_resultDisplayPnl.show(this.resultDisplayPnl, "결과창");
		this.resultSummuryBtn.setVisible(true);
		printAllUserLotto();
		printWinLotto();
	}
}
