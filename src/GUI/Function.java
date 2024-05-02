package GUI;

import java.net.URL;
import java.util.*;
import javax.swing.*;

import number.*;

public class Function {

	private List<JRadioButton> btnList;
	private List<JTextField> tfList;
	private Map<JPanel, List<JLabel>> pnlMap;
	private Set<Integer> intSet;
	private List<Set<Integer>> confirmedList;
	private LottoProgram lottoProgram;

	public Set<Integer> getIntSet() {
		return intSet;
	}

	public void setIntSet(Set<Integer> intSet) {
		this.intSet = intSet;
	}

	public LottoProgram getLottoProgram() {
		return lottoProgram;
	}

	public void setLottoProgram(LottoProgram lottoProgram) {
		this.lottoProgram = lottoProgram;
	}

	public List<Set<Integer>> getConfirmedList() {
		return confirmedList;
	}

	public void setConfirmedList(List<Set<Integer>> confirmedList) {
		this.confirmedList = confirmedList;
	}

	public Function(LottoGUI gui) {
		super();
		this.btnList = gui.getRadioList();
		this.tfList = gui.getTfList();
		this.pnlMap = gui.getPnlMap();
		this.lottoProgram = gui.getLottoProgram();
		this.intSet = new TreeSet<>();
		this.confirmedList = new ArrayList<>();
	}

	/**
	 * 버튼을 눌렀을때, 버튼의 상태(안눌러짐)를 판단하여 로또 번호를 추가할지 말지 결정하는 메소드
	 * @param rdb 상태를 확인할 버튼
	 */
	public void buttonSelect(JRadioButton rdb) {
		if (maxNumberCheck()) {
			rdb.setSelected(false);
		} else {
			intSet.add(Integer.valueOf(rdb.getText()));
			numberUpdate();
		}
	}

	/**
	 * 버튼을 눌렀을때, 버튼의 상태(눌러짐)를 판단하여 로또 번호를 추가할지 말지 결정하는 메소드
	 * @param rdb 상태를 확인할 버튼
	 */
	public void buttonDeselect(JRadioButton rdb) {
		intSet.remove(Integer.valueOf(rdb.getText()));
		numberUpdate();
	}

	/**
	 * 동작이 끝난 후, 보이는 번호를 최신화하기위한 메소드
	 */
	public void numberUpdate() {
		for (JRadioButton btn : btnList) {
			btn.setSelected(false);
		}
		for (JTextField tf : tfList) {
			tf.setText("");
		}
		int index = 0;
		for (Integer i : intSet) {
			btnList.get(i - 1).setSelected(true);
			tfList.get(index).setText(i.toString());
			index++;
		}
	}

	/**
	 * 번호가 적합한지를 판단후, 번호를 추가하고 boolean값을 리턴하는 메소드
	 * @param input 범위를 검사할 번호
	 * @return input이 1이상 45이하일경우 true, 아니면 false
	 */
	public boolean addNum(int input) {
		if (input >= 1 && input <= 45) {
			intSet.add(input);
			numberUpdate();
			return true;
		}
		return false;
	}

	/**
	 * 번호를 삭제하는 메소드
	 * @param input 삭제할 번호
	 */
	public void removeNum(int input) {
		intSet.remove(input);
		btnList.get(input - 1).setSelected(false);
	}

	/**
	 * 지금 선택된 번호가 6개 이하인지 검사하는 메소드
	 * @return 6개일때 true, 아니면 false
	 */
	public boolean maxNumberCheck() {
		if (intSet.size() == 6) {
			return true;
		}
		return false;
	}

	/**
	 * 선택된 번호와 버튼의 상태를 모두 초기화하는 메소드
	 */
	public void resetLotto() {
		for (JRadioButton rdb : btnList) {
			rdb.setSelected(false);
		}
		for (JTextField tf : tfList) {
			tf.setText("");
		}
		intSet.clear();
	}

	/**
	 * 번호가 6개가 될 때까지 자동으로 랜덤한 번호를 추가하는 메소드
	 * 만약 이미 선택된 번호가 6개일때 메소드를 실행하면, 기존 번호를 초기화하고<br>
	 * 새로운 6개의 번호를 랜덤으로 추가함
	 */
	public void autoLotto() {
		if (intSet.size() == 6) {
			this.resetLotto();
		}
		Random rand = new Random();
		while (intSet.size() < 6) {
			int randNum = rand.nextInt(45) + 1;
			intSet.add(randNum);
		}
		for (JRadioButton rdb : btnList) {
			rdb.setSelected(false);
		}
		for (JTextField tf : tfList) {
			tf.setText("");
		}
		int index = 0;
		for (Integer i : intSet) {
			btnList.get(i - 1).setSelected(true);
			tfList.get(index).setText(i.toString());
			index++;
		}
	}

	/**
	 * 확정된 로또를 List에 저장하는 메소드
	 */
	public void confirmLotto() {
		if (confirmedList.size() == 5) {
			return;
		}
		if (intSet.size() != 6) {
			return;
		}
		Set<Integer> tempSet = new TreeSet<>();
		for (Integer i : intSet) {
			tempSet.add(i);
		}
		confirmedList.add(tempSet);
		confirmedUpdate();
	}

	/**
	 * 확정한 로또 패널 정보를 List에서 삭제하는 메소드
	 * @param btnNumber 삭제 버튼을 누른 라벨의 버튼
	 */
	public void removeConfirmedLotto(String btnNumber) {
		int index = Integer.valueOf(btnNumber) - 1;
		confirmedList.remove(index);
		confirmedUpdate();
	}

	/**
	 * 확정된 로또 리스트를 정렬해서 보여주는 메소드
	 */
	public void confirmedUpdate() {
		int index = 0;
		for (JPanel pnl : pnlMap.keySet()) {
			pnl.setVisible(false);
			if (index < confirmedList.size()) {
				TreeSet<Integer> tempSet = new TreeSet<>();
				Set<Integer> refSet = confirmedList.get(index);
				for (Integer elem : refSet) {
					tempSet.add(elem);
				}
				List<JLabel> lblList = pnlMap.get(pnl);
				for (JLabel lbl : lblList) {
					Integer setNum = tempSet.first();
					String fileName = "/GUI/lottoNumbers/" + setNum.toString() + ".png";
					URL imgUrl = Function.class.getResource(fileName);
					lbl.setIcon(new ImageIcon(imgUrl));
					lbl.setIconTextGap(-14);
					lbl.setText("");
					tempSet.remove(setNum);
				}
				pnl.setVisible(true);
				index++;
			}
		}
	}

	/**
	 * 로또 구매버튼을 누를 시 작동하는 메소드<br>
	 * 확정된 로또들을 유저의 개인정보에 저장함
	 */
	public void purchaseLotto() {
		List<Integer> tempList = new ArrayList<>();
		for (Set<Integer> tempSet : confirmedList) {
			tempList.clear();
			for (Integer i : tempSet) {
				tempList.add(i);
			}
			int i1 = tempList.get(0);
			int i2 = tempList.get(1);
			int i3 = tempList.get(2);
			int i4 = tempList.get(3);
			int i5 = tempList.get(4);
			int i6 = tempList.get(5);
			lottoProgram.addUserLotto(i1, i2, i3, i4, i5, i6);
		}
		confirmedList.clear();
		numberUpdate();
		confirmedUpdate();
	}
	/**
	 * 구매창을 나올때 모든 요소를 초기화하는 메소드
	 */
	public void exitPurchase() {
		intSet.clear();
		confirmedList.clear();
		numberUpdate();
		confirmedUpdate();
	}
}
