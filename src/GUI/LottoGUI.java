package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import number.LottoProgram;

public class LottoGUI extends JFrame {
	private String id;
	private String password;
	private User loggedInUser;
	private LoginManager loginManager;
	private JPanel contentPane;
	private JTextField loginTfId;
	private JTextField purchaseLottoTf_1;
	private JTextField purchaseLottoTf_2;
	private JTextField purchaseLottoTf_3;
	private JTextField purchaseLottoTf_4;
	private JTextField purchaseLottoTf_5;
	private JTextField purchaseLottoTf_6;
	private JPasswordField loginPwPwf;
	private List<JRadioButton> radioList;
	private List<JTextField> tfList;
	private Map<JPanel, List<JLabel>> pnlMap;
	private JLabel mainMoneyLbl;
	private LottoProgram lottoProgram;
	private JLabel purchaseMoneyLbl;

	private JPanel resultTotalListPnl;
	private JPanel resultWinListPnl;
	private List<JLabel> lblList;
	private int lblIndex; 
	private JLabel resultWinNumber_plus;
	private CardLayout cl_resultDisplayPnl;
	private JPanel resultDisplayPnl;
	private JLabel mainNameLbl;
	private JButton resultSummuryBtn;
	private JButton resultExitBtn;
	private JScrollPane resultTotalScroll;
	private JScrollPane resultWinScroll;
	private JPanel resultDrawPnl;
	private JPanel listTotalPnl;
	private JScrollPane listScroll;
	private Set<Integer> drawNumberSet;
	private JTextField inputMoney;
	private JButton purchaseConfirmBtn;
	private JButton purchaseBuyBtn;
	private boolean isShowPurchasePnl;
	private Function function;
	private int initialX;
	private int initialY;
	
	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public JPanel getListTotalPnl() {
		return listTotalPnl;
	}

	public void setListTotalPnl(JPanel listTotalPnl) {
		this.listTotalPnl = listTotalPnl;
	}

	public JButton getResultSummuryBtn() {
		return resultSummuryBtn;
	}

	public void setResultSummuryBtn(JButton resultSummuryBtn) {
		this.resultSummuryBtn = resultSummuryBtn;
	}

	public JPanel getResultWinListPnl() {
		return resultWinListPnl;
	}

	public void setResultWinListPnl(JPanel resultWinListPnl) {
		this.resultWinListPnl = resultWinListPnl;
	}

	public JPanel getResultDisplayPnl() {
		return resultDisplayPnl;
	}

	public void setResultDisplayPnl(JPanel resultDisplayPnl) {
		this.resultDisplayPnl = resultDisplayPnl;
	}

	public CardLayout getCl_resultDisplayPnl() {
		return cl_resultDisplayPnl;
	}

	public void setCl_resultDisplayPnl(CardLayout cl_resultDisplayPnl) {
		this.cl_resultDisplayPnl = cl_resultDisplayPnl;
	}

	public JPanel getResultTotalListPnl() {
		return resultTotalListPnl;
	}

	public void setResultTotalListPnl(JPanel resultTotalListPnl) {
		this.resultTotalListPnl = resultTotalListPnl;
	}

	public LottoProgram getLottoProgram() {
		return lottoProgram;
	}

	public void setLottoProgram(LottoProgram lottoProgram) {
		this.lottoProgram = lottoProgram;
	}

	public Map<JPanel, List<JLabel>> getPnlMap() {
		return pnlMap;
	}

	public void setPnlMap(Map<JPanel, List<JLabel>> pnlMap) {
		this.pnlMap = pnlMap;
	}

	public List<JRadioButton> getRadioList() {
		return radioList;
	}

	public void setRadioList(List<JRadioButton> radioList) {
		this.radioList = radioList;
	}

	public List<JTextField> getTfList() {
		return tfList;
	}

	public void setTfList(List<JTextField> tfList) {
		this.tfList = tfList;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LottoGUI frame = new LottoGUI();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LottoGUI() {
		cl_resultDisplayPnl = new CardLayout();
		resultDisplayPnl = new JPanel();
		resultTotalListPnl = new JPanel();
		resultWinListPnl = new JPanel();
		listTotalPnl = new JPanel();
		resultSummuryBtn = new JButton("");
		resultSummuryBtn.setBorder(null);
		resultSummuryBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uC694\uC57D \uBC84\uD2BC.png")));
		resultTotalListPnl.setBackground(Color.WHITE);
		radioList = new ArrayList<>();
		tfList = new ArrayList<>();
		pnlMap = new LinkedHashMap<>();
		function = new Function(this);
		lottoProgram = new LottoProgram(this);
		JButton resultTotalBtn = new JButton("");
		this.drawNumberSet = new TreeSet<>();

		resultTotalScroll = new JScrollPane(resultTotalListPnl);
		resultWinScroll = new JScrollPane(resultWinListPnl);
		resultExitBtn = new JButton("");
		ActionListener btnAction_radio = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton btn = (JRadioButton) e.getSource();
				if (!btn.isSelected()) {
					function.buttonDeselect(btn);
				} else {
					function.buttonSelect(btn);
				}
			}
		};
		ActionListener btnAction_reset = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				function.resetLotto();
			}
		};
		ActionListener btnAction_auto = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				function.autoLotto();
			}
		};
		ActionListener btnAction_confirm = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (function.getIntSet().size() == 0) {
					function.autoLotto();
					function.confirmLotto();
					function.autoLotto();
					function.confirmLotto();
					function.autoLotto();
					function.confirmLotto();
					function.autoLotto();
					function.confirmLotto();
					function.autoLotto();
					function.confirmLotto();
					function.resetLotto();
				} else {
					function.confirmLotto();
				}
			}
		};
		ActionListener btnAction_delete = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				function.removeConfirmedLotto(e.getActionCommand());
			}
		};
		ActionListener btnAction_purchase = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int price = function.getConfirmedList().size() * 1000;
				int userMoney = loggedInUser.getSeedmoney();

				if (userMoney >= price) {
					function.purchaseLotto();
					int afterMoney = userMoney - price;
					loggedInUser.setSeedmoney(afterMoney);
					purchaseMoneyLbl.setText(String.valueOf(loggedInUser.getSeedmoney()) + "원");
				} else {
					int result = JOptionPane.showOptionDialog(null, "잔액이 부족합니다. 금액을 충전하시겠습니까?", "",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

					if (result == JOptionPane.YES_OPTION) {
						LottoGUI gui = returnSelf();
						showMoneyDialog(gui);
//						boolean go = true;
//						while (go) {
//							try {
//								int chargeMoney = Integer
//										.valueOf(JOptionPane.showInputDialog("1000원 ~ 1억 원 사이의 금액을 입력하세요."));
//								int totalMoneyAfterCharge = loggedInUser.getSeedmoney() + chargeMoney;
//
//								if (totalMoneyAfterCharge < 100000000) {
//									JOptionPane.showMessageDialog(null, "충전이 완료되었습니다.");
//									go = false;
//
//									User.moneyplus(loggedInUser, chargeMoney);
//
//									purchaseMoneyLbl.setText(String.valueOf(loggedInUser.getSeedmoney()) + "원");
//								} else {
//									if (totalMoneyAfterCharge > 100000000) {
//										JOptionPane.showMessageDialog(null, "1억 원을 초과하여 충전할 수 없습니다.");
//									} else {
//										JOptionPane.showMessageDialog(null, "1000원  ~ 1억 원 사이의 금액을 입력하세요.");
//									}
//								}
//							} catch (NumberFormatException ex) {
//								go = false;
//							} catch (HeadlessException ex) {
//								go = false;
//							}
//						}
					}
				}
			}
		};
		MouseAdapter lblClkmeMouseAdapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (lblIndex == 6) {
					resultTotalListPnl = new JPanel();
					resultTotalListPnl.setSize(new Dimension(522, 351));
					resultTotalListPnl.setLayout(new GridLayout(0, 1, 0, 0));
					resultTotalListPnl.setBackground(Color.WHITE);
					resultWinListPnl = new JPanel();
					resultWinListPnl.setSize(new Dimension(522, 351));
					resultWinListPnl.setLayout(new GridLayout(0, 1, 0, 0));
					resultWinListPnl.setBackground(Color.WHITE);
					JViewport sc1Viewport = new JViewport();
					sc1Viewport.add(resultTotalListPnl);
					resultTotalScroll.setViewport(sc1Viewport);
					JViewport sc2Viewport = new JViewport();
					sc2Viewport.add(resultWinListPnl);
					resultWinScroll.setViewport(sc2Viewport);
					resultDisplayPnl.add(resultTotalScroll, "결과창");
					resultDisplayPnl.add(resultWinScroll, "요약결과창");
				}
				makeBall(lottoProgram.makeDrawLotto());
				if (lblIndex < 7) {
					resultExitBtn.setVisible(false);
				} else {
					resultExitBtn.setVisible(true);
					drawNumberEnd();
				}
			}
		};
		MouseAdapter lblGifMouseAdapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				resultTotalListPnl = new JPanel();
				resultTotalListPnl.setSize(new Dimension(522, 351));
				resultTotalListPnl.setLayout(new GridLayout(0, 1, 0, 0));
				resultTotalListPnl.setBackground(Color.WHITE);
				resultWinListPnl = new JPanel();
				resultWinListPnl.setSize(new Dimension(522, 351));
				resultWinListPnl.setLayout(new GridLayout(0, 1, 0, 0));
				resultWinListPnl.setBackground(Color.WHITE);
				JViewport sc1Viewport = new JViewport();
				sc1Viewport.add(resultTotalListPnl);
				resultTotalScroll.setViewport(sc1Viewport);
				JViewport sc2Viewport = new JViewport();
				sc2Viewport.add(resultWinListPnl);
				resultWinScroll.setViewport(sc2Viewport);
				resultDisplayPnl.add(resultTotalScroll, "결과창");
				resultDisplayPnl.add(resultWinScroll, "요약결과창");
				drawNumberAuto();
				if (lblIndex < 7) {
					resultExitBtn.setVisible(false);
				} else {
					resultExitBtn.setVisible(true);
					drawNumberEnd();
				}
			}
		};

//		// 텍스트필드 포커스리스너(미사용)
//		FocusListener tfFocus = new FocusListener() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				JTextField tf = (JTextField) e.getSource();
//				if (!tf.getText().equals("")) {
//					int tfNum = Integer.valueOf(tf.getText());
//					if (!function.addNum(tfNum)) {
//						tf.setText("");
//						function.numberUpdate();
//					}
//				} else {
//					function.numberUpdate();
//				}
//			}
//
//			@Override
//			public void focusGained(FocusEvent e) {
//				JTextField tf = (JTextField) e.getSource();
//				if (!tf.getText().equals("")) {
//					int tfNum = Integer.valueOf(tf.getText());
//					function.removeNum(tfNum);
//					tf.setText("");
//				}
//			}
//		};

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 607);
		setLocation(500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		CardLayout card = new CardLayout();
		panel.setLayout(card);

		JPanel loginPnl = new JPanel();
		panel.add(loginPnl, "로그인창");
		SpringLayout sl_loginPnl = new SpringLayout();
		loginPnl.setLayout(sl_loginPnl);

		JLabel loginLbl = new JLabel("\uC0AC\uB791\uACFC \uD568\uAED8\uD558\uB294 \uC815\uC131\uC885 \uBCF5\uAD8C");
		sl_loginPnl.putConstraint(SpringLayout.NORTH, loginLbl, 50, SpringLayout.NORTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.WEST, loginLbl, 0, SpringLayout.WEST, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.EAST, loginLbl, 0, SpringLayout.EAST, loginPnl);
		loginLbl.setHorizontalAlignment(SwingConstants.CENTER);
		loginLbl.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		loginPnl.add(loginLbl);

		loginTfId = new JTextField();
		loginTfId.setBorder(new LineBorder(Color.LIGHT_GRAY));
		sl_loginPnl.putConstraint(SpringLayout.NORTH, loginTfId, -200, SpringLayout.SOUTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.WEST, loginTfId, -400, SpringLayout.EAST, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.SOUTH, loginTfId, -150, SpringLayout.SOUTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.EAST, loginTfId, -180, SpringLayout.EAST, loginPnl);
		loginTfId.setText("1234");
		loginTfId.setFont(new Font("굴림", Font.PLAIN, 17));
		loginPnl.add(loginTfId);
		loginTfId.setColumns(10);

		JButton loginLoginBtn = new JButton("");

		sl_loginPnl.putConstraint(SpringLayout.NORTH, loginLoginBtn, -200, SpringLayout.SOUTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.SOUTH, loginLoginBtn, -150, SpringLayout.SOUTH, loginPnl);
		loginLoginBtn.setBorder(null);
		loginManager = new LoginManager();
		// 로그인 버튼

		loginLoginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				id = loginTfId.getText();
				password = loginPwPwf.getText();
				loggedInUser = loginManager.loginCke(id, password);
				if (loggedInUser != null) {
					mainMoneyLbl.setText(String.valueOf(loggedInUser.getSeedmoney()) + "원");
					returnSelf().setLottoProgram(loggedInUser.getLotto());
					function.setLottoProgram(loggedInUser.getLotto());
					card.show(panel, "메인창");
					mainNameLbl.setText(loggedInUser.getName());

					loginTfId.setText("");
					loginPwPwf.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "유저 정보가 일치하지 않습니다.");
				}

			}

		});
		Font gainFont = new Font("", Font.BOLD, 25);
		Font lostFont = new Font("", Font.BOLD, 25);
		loginTfId.setToolTipText("아이디를 입력하세요.");
		loginTfId.setText("ID");
		loginTfId.setFont(lostFont);
		loginTfId.setForeground(Color.GRAY);
		loginTfId.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (loginTfId.getText().equals("")) {
					loginTfId.setText("ID");
					loginTfId.setFont(lostFont);
					loginTfId.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (loginTfId.getText().equals("ID")) {
					loginTfId.setText("");
					loginTfId.setFont(gainFont);
					loginTfId.setForeground(Color.BLACK);
				}
			}
		});
		sl_loginPnl.putConstraint(SpringLayout.WEST, loginLoginBtn, 720, SpringLayout.WEST, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.EAST, loginLoginBtn, -30, SpringLayout.EAST, loginPnl);
		loginLoginBtn.setIconTextGap(-20);
		loginLoginBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uB85C\uADF8\uC778 \uBC84\uD2BC.png")));
		loginLoginBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/로그인 버튼누름.png")));
		// btnNewButton.addActionListener();
		loginLoginBtn.setFont(new Font("굴림", Font.PLAIN, 18));
		loginPnl.add(loginLoginBtn);

		JButton loginExitBtn = new JButton("");
		sl_loginPnl.putConstraint(SpringLayout.NORTH, loginExitBtn, -110, SpringLayout.SOUTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.SOUTH, loginExitBtn, -60, SpringLayout.SOUTH, loginPnl);
		loginExitBtn.setBorder(null);
		sl_loginPnl.putConstraint(SpringLayout.WEST, loginExitBtn, 720, SpringLayout.WEST, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.EAST, loginExitBtn, -30, SpringLayout.EAST, loginPnl);
		loginExitBtn.setIconTextGap(-20);
		loginExitBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uC885\uB8CC \uBC84\uD2BC.png")));
		loginExitBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/종료 버튼누름.png")));
		loginExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		loginExitBtn.setFont(new Font("굴림", Font.PLAIN, 18));
		loginPnl.add(loginExitBtn);

		loginPwPwf = new JPasswordField();
		loginPwPwf.setBorder(new LineBorder(Color.LIGHT_GRAY));
		loginPwPwf.setLayout(new BorderLayout());
		sl_loginPnl.putConstraint(SpringLayout.NORTH, loginPwPwf, -110, SpringLayout.SOUTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.WEST, loginPwPwf, -400, SpringLayout.EAST, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.SOUTH, loginPwPwf, -60, SpringLayout.SOUTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.EAST, loginPwPwf, -180, SpringLayout.EAST, loginPnl);
		loginPwPwf.setText("");
		loginPwPwf.setToolTipText("비밀번호를 입력하세요.");
		loginPnl.add(loginPwPwf);

		JButton loginRegisterBtn = new JButton("");
		loginRegisterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSignUpDialog();

			}
		});
		sl_loginPnl.putConstraint(SpringLayout.WEST, loginRegisterBtn, 540, SpringLayout.WEST, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.EAST, loginRegisterBtn, -100, SpringLayout.EAST, loginPnl);
		loginRegisterBtn
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uD68C\uC6D0\uAC00\uC785 \uBC84\uD2BC.png")));
		loginRegisterBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/회원가입 버튼누름.png")));
		loginRegisterBtn.setBorder(null);
		sl_loginPnl.putConstraint(SpringLayout.NORTH, loginRegisterBtn, -290, SpringLayout.SOUTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.SOUTH, loginRegisterBtn, -240, SpringLayout.SOUTH, loginPnl);
		loginPnl.add(loginRegisterBtn);

		JLabel loginBackgroundLbl = new JLabel("");
		loginBackgroundLbl
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uB85C\uADF8\uC778 \uBC30\uACBD.png")));
		sl_loginPnl.putConstraint(SpringLayout.NORTH, loginBackgroundLbl, 0, SpringLayout.NORTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.WEST, loginBackgroundLbl, 0, SpringLayout.WEST, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.SOUTH, loginBackgroundLbl, 0, SpringLayout.SOUTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.EAST, loginBackgroundLbl, 0, SpringLayout.EAST, loginPnl);
		loginPnl.add(loginBackgroundLbl);

		JLabel loginPwMaskLbl = new JLabel("PASSWORD");
		sl_loginPnl.putConstraint(SpringLayout.NORTH, loginPwMaskLbl, -110, SpringLayout.SOUTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.WEST, loginPwMaskLbl, -400, SpringLayout.EAST, loginLbl);
		sl_loginPnl.putConstraint(SpringLayout.SOUTH, loginPwMaskLbl, -60, SpringLayout.SOUTH, loginPnl);
		sl_loginPnl.putConstraint(SpringLayout.EAST, loginPwMaskLbl, -180, SpringLayout.EAST, loginPnl);
		// loginPnl.add(lblNewLabel_2);
		loginPwPwf.add(loginPwMaskLbl);
		loginPwMaskLbl.setFont(lostFont);
		loginPwMaskLbl.setForeground(Color.GRAY);
		loginPwPwf.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (loginPwPwf.getText().length() == 0) {
					loginPwMaskLbl.setVisible(true);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				loginPwMaskLbl.setVisible(false);

			}
		});

		JPanel mainPnl = new JPanel();
		panel.add(mainPnl, "메인창");
		SpringLayout sl_mainPnl = new SpringLayout();
		mainPnl.setLayout(sl_mainPnl);

		JLabel mainTitleLbl = new JLabel("\uC0AC\uB791\uACFC \uD568\uAED8\uD558\uB294 \uC815\uC131\uC885 \uBCF5\uAD8C");
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainTitleLbl, 50, SpringLayout.NORTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.WEST, mainTitleLbl, 0, SpringLayout.WEST, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainTitleLbl, -200, SpringLayout.EAST, mainPnl);
		mainTitleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		mainTitleLbl.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		mainPnl.add(mainTitleLbl);

		JButton mainPurchaseBtn = new JButton("");
		mainPurchaseBtn.setBorder(null);
		mainPurchaseBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uAD6C\uB9E4 \uBC84\uD2BC.png")));
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainPurchaseBtn, -360, SpringLayout.SOUTH, mainPnl);
		mainPurchaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "구매창");
				purchaseMoneyLbl.setText(String.valueOf(loggedInUser.getSeedmoney()) + "원");
				isShowPurchasePnl = true;

			}
		});
		sl_mainPnl.putConstraint(SpringLayout.WEST, mainPurchaseBtn, 42, SpringLayout.WEST, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.SOUTH, mainPurchaseBtn, -80, SpringLayout.SOUTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainPurchaseBtn, -582, SpringLayout.EAST, mainPnl);
		mainPurchaseBtn.setFont(new Font("굴림", Font.PLAIN, 50));
		mainPnl.add(mainPurchaseBtn);

		JButton mainResultBtn = new JButton("");
		sl_mainPnl.putConstraint(SpringLayout.WEST, mainResultBtn, 366, SpringLayout.WEST, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainResultBtn, -258, SpringLayout.EAST, mainPnl);
		mainResultBtn.setBorder(null);
		mainResultBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uACB0\uACFC \uBC84\uD2BC.png")));
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainResultBtn, -360, SpringLayout.SOUTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.SOUTH, mainResultBtn, -80, SpringLayout.SOUTH, mainPnl);
		mainResultBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "결과창");
			}
		});
		mainResultBtn.setFont(new Font("굴림", Font.PLAIN, 50));
		mainPnl.add(mainResultBtn);

		JButton mainLogoutBtn = new JButton("");
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainLogoutBtn, -110, SpringLayout.SOUTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.WEST, mainLogoutBtn, 720, SpringLayout.WEST, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.SOUTH, mainLogoutBtn, -60, SpringLayout.SOUTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainLogoutBtn, -30, SpringLayout.EAST, mainPnl);
		mainLogoutBtn
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uB85C\uADF8\uC544\uC6C3 \uBC84\uD2BC.png")));
		mainLogoutBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/로그아웃 버튼누름.png")));
		mainLogoutBtn.setBorder(null);
		mainLogoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "로그인창");
			}
		});
		mainPnl.add(mainLogoutBtn);

		JButton mainChargeBtn = new JButton();
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainChargeBtn, -200, SpringLayout.SOUTH, mainPnl);

		sl_mainPnl.putConstraint(SpringLayout.WEST, mainChargeBtn, 720, SpringLayout.WEST, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.SOUTH, mainChargeBtn, -150, SpringLayout.SOUTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainChargeBtn, -30, SpringLayout.EAST, mainPnl);
		mainChargeBtn.setBorder(null);
		mainChargeBtn.setIconTextGap(-14);
		mainChargeBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uCDA9\uC804 \uBC84\uD2BC.png")));
		mainChargeBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/충전 버튼누름.png")));

		mainChargeBtn.addActionListener(new ActionListener() {
			private Integer chargeMoney;

			public void actionPerformed(ActionEvent arg0) {
				LottoGUI gui = returnSelf();
				showMoneyDialog(gui);
//				boolean go = true;
//				while (go) {
//					try {
//						chargeMoney = Integer.valueOf(JOptionPane.showInputDialog("1000원 ~ 1억 원 사이의 금액을 입력하세요."));
//						int totalMoneyAfterCharge = loggedInUser.getSeedmoney() + chargeMoney;
//
//						if (chargeMoney != null && chargeMoney >= 1000 && chargeMoney <= 100000000
//								&& totalMoneyAfterCharge <= 100000000) {
//							JOptionPane.showMessageDialog(mainPnl, "충전이 완료되었습니다.");
//							go = false;
//
//							User.moneyplus(loggedInUser, chargeMoney);
//
//						} else {
//							if (totalMoneyAfterCharge > 100000000) {
//								JOptionPane.showMessageDialog(mainPnl, "1억 원을 초과하여 충전할 수 없습니다.");
//							} else {
//								JOptionPane.showMessageDialog(mainPnl, "1000원 ~ 1억 원 사이의 금액을 입력하세요.");
//							}
//						}
//					} catch (NumberFormatException e) {
//						go = false;
//					} catch (HeadlessException e) {
//						go = false;
//					}
//				}
			}
		});
		/*
		 * //---------------마스크포메터 충전------------ btnCharge.addActionListener(new
		 * ActionListener() { private Integer chargeMoney;
		 * 
		 * public void actionPerformed(ActionEvent arg0) { boolean go = true; while (go)
		 * { try { MaskFormatter mask = new MaskFormatter("##" + "," + "###" + ",000");
		 * // 12 digits
		 * 
		 * mask.setPlaceholderCharacter(' '); JFormattedTextField formattedTextField =
		 * new JFormattedTextField(mask); formattedTextField.setColumns(12);
		 * 
		 * Object[] message = { "1000원 단위의 1억 원 이하의 금액을 입력하세요:", formattedTextField };
		 * 
		 * int option = JOptionPane.showOptionDialog(null, message, "Charge",
		 * JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
		 * null);
		 * 
		 * if (option == JOptionPane.CANCEL_OPTION) { go = false; break; }
		 * 
		 * chargeMoney = Integer.valueOf(formattedTextField.getText()); int
		 * totalMoneyAfterCharge = loggedInUser.getSeedmoney() + chargeMoney;
		 * 
		 * if (chargeMoney >= 1000 && chargeMoney <= 10000000 && chargeMoney % 1000 ==
		 * 0) { if (totalMoneyAfterCharge <= 10000000) {
		 * JOptionPane.showMessageDialog(null, "충전이 완료되었습니다."); go = false;
		 * 
		 * User.moneyplus(loggedInUser, chargeMoney);
		 * 
		 * lblNewLabel_4.setText(String.valueOf(loggedInUser.getSeedmoney()) + "원"); }
		 * else { JOptionPane.showMessageDialog(null, "100억 원을 초과하여 충전할 수 없습니다."); } }
		 * else if (!((chargeMoney & 1000) == 0)) { JOptionPane.showMessageDialog(null,
		 * "천원 단위의 금액을 입력해 주세요."); } else { JOptionPane.showMessageDialog(null,
		 * "1000원 ~ 1억 원 사이의 금액을 입력하세요."); } } catch (NumberFormatException e) {
		 * JOptionPane.showMessageDialog(null, "유효한 금액을 입력하세요."); } catch
		 * (ParseException e) { JOptionPane.showMessageDialog(null,
		 * "유효한 형식의 금액을 입력하세요."); } } } });
		 */

		mainPnl.add(mainChargeBtn);

		// 이름 라벨
		mainNameLbl = new JLabel("정성종");
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainNameLbl, -40, SpringLayout.EAST, mainPnl);
		mainNameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainNameLbl, -360, SpringLayout.SOUTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.WEST, mainNameLbl, 730, SpringLayout.WEST, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.SOUTH, mainNameLbl, -310, SpringLayout.SOUTH, mainPnl);
		mainNameLbl.setFont(new Font("굴림", Font.PLAIN, 20));
		mainPnl.add(mainNameLbl);

		mainMoneyLbl = new JLabel("0\uC6D0");
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainMoneyLbl, -50, SpringLayout.EAST, mainPnl);
		mainMoneyLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		sl_mainPnl.putConstraint(SpringLayout.WEST, mainMoneyLbl, 730, SpringLayout.WEST, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.SOUTH, mainMoneyLbl, -60, SpringLayout.NORTH, mainChargeBtn);
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainMoneyLbl, 270, SpringLayout.NORTH, mainPnl);
		mainMoneyLbl.setFont(new Font("굴림", Font.PLAIN, 20));
		mainPnl.add(mainMoneyLbl);

		JLabel mainSubtitleLbl = new JLabel(
				"\uC990\uAE38\uB550 \uC801\uB2F9\uD558\uAC8C \uBA48\uCD9C\uB550 \uB2E8\uD638\uD558\uAC8C");
		sl_mainPnl.putConstraint(SpringLayout.SOUTH, mainSubtitleLbl, 80, SpringLayout.SOUTH, mainTitleLbl);
		mainSubtitleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		mainSubtitleLbl.setFont(new Font("궁서", Font.PLAIN, 20));
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainSubtitleLbl, 32, SpringLayout.SOUTH, mainTitleLbl);
		sl_mainPnl.putConstraint(SpringLayout.WEST, mainSubtitleLbl, 0, SpringLayout.WEST, mainTitleLbl);
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainSubtitleLbl, 0, SpringLayout.EAST, mainTitleLbl);
		mainPnl.add(mainSubtitleLbl);

		JButton mainListLbl = new JButton("");
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainListLbl, -555, SpringLayout.SOUTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.WEST, mainListLbl, 710, SpringLayout.WEST, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.SOUTH, mainListLbl, -440, SpringLayout.SOUTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainListLbl, -30, SpringLayout.EAST, mainPnl);
		mainListLbl.setBorder(null);
		mainListLbl
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uAD6C\uB9E4\uB0B4\uC5ED \uBC84\uD2BC.png")));
		mainPnl.add(mainListLbl);
		mainListLbl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listTotalPnl = new JPanel();
				listTotalPnl.setSize(new Dimension(111, 111));
				listTotalPnl.setLayout(new GridLayout(0, 1, 0, 0));
				listTotalPnl.setBackground(Color.WHITE);

				JViewport sc3Viewport = new JViewport();
				sc3Viewport.add(listTotalPnl);
				listScroll.setViewport(sc3Viewport);
				lottoProgram.printPurchaseLotto();
				card.show(panel, "구매내역창");
			}
		});
		JButton mainEsterEggBtn = new JButton("");
		mainEsterEggBtn.setBorderPainted(false);
		mainEsterEggBtn.setFocusPainted(false);
		mainEsterEggBtn.setContentAreaFilled(false);
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainEsterEggBtn, 50, SpringLayout.NORTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.WEST, mainEsterEggBtn, 150, SpringLayout.WEST, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.SOUTH, mainEsterEggBtn, 80, SpringLayout.NORTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainEsterEggBtn, 210, SpringLayout.WEST, mainPnl);
		mainPnl.add(mainEsterEggBtn);
		mainEsterEggBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainPnl, "Object superSexyGuy = \"Mr. 박민\";");

			}
		});

		JLabel mainBackgroundLbl = new JLabel("");
		mainBackgroundLbl.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uBA54\uC778\uD654\uBA74.png")));
		sl_mainPnl.putConstraint(SpringLayout.NORTH, mainBackgroundLbl, 0, SpringLayout.NORTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.WEST, mainBackgroundLbl, 0, SpringLayout.WEST, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.SOUTH, mainBackgroundLbl, 0, SpringLayout.SOUTH, mainPnl);
		sl_mainPnl.putConstraint(SpringLayout.EAST, mainBackgroundLbl, 0, SpringLayout.EAST, mainPnl);
		mainPnl.add(mainBackgroundLbl);

		JPanel purchasePnl = new JPanel();
		panel.add(purchasePnl, "구매창");
		SpringLayout sl_purchasePnl = new SpringLayout();
		purchasePnl.setLayout(sl_purchasePnl);

		JPanel purchaseLottoRdbPnl = new JPanel();
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseLottoRdbPnl, 29, SpringLayout.NORTH, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseLottoRdbPnl, 21, SpringLayout.WEST, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseLottoRdbPnl, 397, SpringLayout.NORTH, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseLottoRdbPnl, 380, SpringLayout.WEST, purchasePnl);
		purchasePnl.add(purchaseLottoRdbPnl);
		purchaseLottoRdbPnl.setLayout(new GridLayout(0, 9, 0, 0));

		JRadioButton purchaseLottoRdb_1 = new JRadioButton("1");
		JRadioButton purchaseLottoRdb_2 = new JRadioButton("2");
		JRadioButton purchaseLottoRdb_3 = new JRadioButton("3");
		JRadioButton purchaseLottoRdb_4 = new JRadioButton("4");
		JRadioButton purchaseLottoRdb_5 = new JRadioButton("5");
		JRadioButton purchaseLottoRdb_6 = new JRadioButton("6");
		JRadioButton purchaseLottoRdb_7 = new JRadioButton("7");
		JRadioButton purchaseLottoRdb_8 = new JRadioButton("8");
		JRadioButton purchaseLottoRdb_9 = new JRadioButton("9");
		JRadioButton purchaseLottoRdb_10 = new JRadioButton("10");
		JRadioButton purchaseLottoRdb_11 = new JRadioButton("11");
		JRadioButton purchaseLottoRdb_12 = new JRadioButton("12");
		JRadioButton purchaseLottoRdb_13 = new JRadioButton("13");
		JRadioButton purchaseLottoRdb_14 = new JRadioButton("14");
		JRadioButton purchaseLottoRdb_15 = new JRadioButton("15");
		JRadioButton purchaseLottoRdb_16 = new JRadioButton("16");
		JRadioButton purchaseLottoRdb_17 = new JRadioButton("17");
		JRadioButton purchaseLottoRdb_18 = new JRadioButton("18");
		JRadioButton purchaseLottoRdb_19 = new JRadioButton("19");
		JRadioButton purchaseLottoRdb_20 = new JRadioButton("20");
		JRadioButton purchaseLottoRdb_21 = new JRadioButton("21");
		JRadioButton purchaseLottoRdb_22 = new JRadioButton("22");
		JRadioButton purchaseLottoRdb_23 = new JRadioButton("23");
		JRadioButton purchaseLottoRdb_24 = new JRadioButton("24");
		JRadioButton purchaseLottoRdb_25 = new JRadioButton("25");
		JRadioButton purchaseLottoRdb_26 = new JRadioButton("26");
		JRadioButton purchaseLottoRdb_27 = new JRadioButton("27");
		JRadioButton purchaseLottoRdb_28 = new JRadioButton("28");
		JRadioButton purchaseLottoRdb_29 = new JRadioButton("29");
		JRadioButton purchaseLottoRdb_30 = new JRadioButton("30");
		JRadioButton purchaseLottoRdb_31 = new JRadioButton("31");
		JRadioButton purchaseLottoRdb_32 = new JRadioButton("32");
		JRadioButton purchaseLottoRdb_33 = new JRadioButton("33");
		JRadioButton purchaseLottoRdb_34 = new JRadioButton("34");
		JRadioButton purchaseLottoRdb_35 = new JRadioButton("35");
		JRadioButton purchaseLottoRdb_36 = new JRadioButton("36");
		JRadioButton purchaseLottoRdb_37 = new JRadioButton("37");
		JRadioButton purchaseLottoRdb_38 = new JRadioButton("38");
		JRadioButton purchaseLottoRdb_39 = new JRadioButton("39");
		JRadioButton purchaseLottoRdb_40 = new JRadioButton("40");
		JRadioButton purchaseLottoRdb_41 = new JRadioButton("41");
		JRadioButton purchaseLottoRdb_42 = new JRadioButton("42");
		JRadioButton purchaseLottoRdb_43 = new JRadioButton("43");
		JRadioButton purchaseLottoRdb_44 = new JRadioButton("44");
		JRadioButton purchaseLottoRdb_45 = new JRadioButton("45");

		purchaseLottoRdb_1.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_2.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_3.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_4.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_5.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_6.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_7.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_8.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_9.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_10.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_11.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_12.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_13.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_14.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_15.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_16.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_17.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_18.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_19.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_20.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_21.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_22.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_23.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_24.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_25.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_26.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_27.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_28.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_29.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_30.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_31.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_32.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_33.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_34.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_35.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_36.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_37.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_38.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_39.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_40.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_41.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_42.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_43.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_44.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_45.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseLottoRdb_1.setBorderPainted(true);
		purchaseLottoRdb_2.setBorderPainted(true);
		purchaseLottoRdb_3.setBorderPainted(true);
		purchaseLottoRdb_4.setBorderPainted(true);
		purchaseLottoRdb_5.setBorderPainted(true);
		purchaseLottoRdb_6.setBorderPainted(true);
		purchaseLottoRdb_7.setBorderPainted(true);
		purchaseLottoRdb_8.setBorderPainted(true);
		purchaseLottoRdb_9.setBorderPainted(true);
		purchaseLottoRdb_10.setBorderPainted(true);
		purchaseLottoRdb_11.setBorderPainted(true);
		purchaseLottoRdb_12.setBorderPainted(true);
		purchaseLottoRdb_13.setBorderPainted(true);
		purchaseLottoRdb_14.setBorderPainted(true);
		purchaseLottoRdb_15.setBorderPainted(true);
		purchaseLottoRdb_16.setBorderPainted(true);
		purchaseLottoRdb_17.setBorderPainted(true);
		purchaseLottoRdb_18.setBorderPainted(true);
		purchaseLottoRdb_19.setBorderPainted(true);
		purchaseLottoRdb_20.setBorderPainted(true);
		purchaseLottoRdb_21.setBorderPainted(true);
		purchaseLottoRdb_22.setBorderPainted(true);
		purchaseLottoRdb_23.setBorderPainted(true);
		purchaseLottoRdb_24.setBorderPainted(true);
		purchaseLottoRdb_25.setBorderPainted(true);
		purchaseLottoRdb_26.setBorderPainted(true);
		purchaseLottoRdb_27.setBorderPainted(true);
		purchaseLottoRdb_28.setBorderPainted(true);
		purchaseLottoRdb_29.setBorderPainted(true);
		purchaseLottoRdb_30.setBorderPainted(true);
		purchaseLottoRdb_31.setBorderPainted(true);
		purchaseLottoRdb_32.setBorderPainted(true);
		purchaseLottoRdb_33.setBorderPainted(true);
		purchaseLottoRdb_34.setBorderPainted(true);
		purchaseLottoRdb_35.setBorderPainted(true);
		purchaseLottoRdb_36.setBorderPainted(true);
		purchaseLottoRdb_37.setBorderPainted(true);
		purchaseLottoRdb_38.setBorderPainted(true);
		purchaseLottoRdb_39.setBorderPainted(true);
		purchaseLottoRdb_40.setBorderPainted(true);
		purchaseLottoRdb_41.setBorderPainted(true);
		purchaseLottoRdb_42.setBorderPainted(true);
		purchaseLottoRdb_43.setBorderPainted(true);
		purchaseLottoRdb_44.setBorderPainted(true);
		purchaseLottoRdb_45.setBorderPainted(true);

		purchaseLottoRdb_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_3.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_5.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_6.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_7.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_8.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_9.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_10.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_11.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_12.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_13.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_14.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_15.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_16.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_17.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_18.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_19.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_20.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_21.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_22.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_23.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_24.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_25.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_26.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_27.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_28.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_29.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_30.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_31.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_32.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_33.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_34.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_35.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_36.setBorder(new LineBorder(Color.DARK_GRAY));
		purchaseLottoRdb_37.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_38.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_39.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_40.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_41.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_42.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_43.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_44.setBorder(new LineBorder(Color.LIGHT_GRAY));
		purchaseLottoRdb_45.setBorder(new LineBorder(Color.LIGHT_GRAY));

		purchaseLottoRdb_1.addActionListener(btnAction_radio);
		purchaseLottoRdb_2.addActionListener(btnAction_radio);
		purchaseLottoRdb_3.addActionListener(btnAction_radio);
		purchaseLottoRdb_4.addActionListener(btnAction_radio);
		purchaseLottoRdb_5.addActionListener(btnAction_radio);
		purchaseLottoRdb_6.addActionListener(btnAction_radio);
		purchaseLottoRdb_7.addActionListener(btnAction_radio);
		purchaseLottoRdb_8.addActionListener(btnAction_radio);
		purchaseLottoRdb_9.addActionListener(btnAction_radio);
		purchaseLottoRdb_10.addActionListener(btnAction_radio);
		purchaseLottoRdb_11.addActionListener(btnAction_radio);
		purchaseLottoRdb_12.addActionListener(btnAction_radio);
		purchaseLottoRdb_13.addActionListener(btnAction_radio);
		purchaseLottoRdb_14.addActionListener(btnAction_radio);
		purchaseLottoRdb_15.addActionListener(btnAction_radio);
		purchaseLottoRdb_16.addActionListener(btnAction_radio);
		purchaseLottoRdb_17.addActionListener(btnAction_radio);
		purchaseLottoRdb_18.addActionListener(btnAction_radio);
		purchaseLottoRdb_19.addActionListener(btnAction_radio);
		purchaseLottoRdb_20.addActionListener(btnAction_radio);
		purchaseLottoRdb_21.addActionListener(btnAction_radio);
		purchaseLottoRdb_22.addActionListener(btnAction_radio);
		purchaseLottoRdb_23.addActionListener(btnAction_radio);
		purchaseLottoRdb_24.addActionListener(btnAction_radio);
		purchaseLottoRdb_25.addActionListener(btnAction_radio);
		purchaseLottoRdb_26.addActionListener(btnAction_radio);
		purchaseLottoRdb_27.addActionListener(btnAction_radio);
		purchaseLottoRdb_28.addActionListener(btnAction_radio);
		purchaseLottoRdb_29.addActionListener(btnAction_radio);
		purchaseLottoRdb_30.addActionListener(btnAction_radio);
		purchaseLottoRdb_31.addActionListener(btnAction_radio);
		purchaseLottoRdb_32.addActionListener(btnAction_radio);
		purchaseLottoRdb_33.addActionListener(btnAction_radio);
		purchaseLottoRdb_34.addActionListener(btnAction_radio);
		purchaseLottoRdb_35.addActionListener(btnAction_radio);
		purchaseLottoRdb_36.addActionListener(btnAction_radio);
		purchaseLottoRdb_37.addActionListener(btnAction_radio);
		purchaseLottoRdb_38.addActionListener(btnAction_radio);
		purchaseLottoRdb_39.addActionListener(btnAction_radio);
		purchaseLottoRdb_40.addActionListener(btnAction_radio);
		purchaseLottoRdb_41.addActionListener(btnAction_radio);
		purchaseLottoRdb_42.addActionListener(btnAction_radio);
		purchaseLottoRdb_43.addActionListener(btnAction_radio);
		purchaseLottoRdb_44.addActionListener(btnAction_radio);
		purchaseLottoRdb_45.addActionListener(btnAction_radio);

		purchaseLottoRdbPnl.add(purchaseLottoRdb_1);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_2);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_3);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_4);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_5);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_6);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_7);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_8);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_9);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_10);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_11);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_12);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_13);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_14);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_15);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_16);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_17);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_18);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_19);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_20);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_21);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_22);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_23);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_24);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_25);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_26);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_27);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_28);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_29);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_30);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_31);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_32);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_33);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_34);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_35);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_36);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_37);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_38);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_39);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_40);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_41);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_42);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_43);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_44);
		purchaseLottoRdbPnl.add(purchaseLottoRdb_45);

		JPanel purchaseLottoTfPnl = new JPanel();
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseLottoTfPnl, 11, SpringLayout.SOUTH,
				purchaseLottoRdbPnl);
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseLottoTfPnl, 21, SpringLayout.WEST, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseLottoTfPnl, 380, SpringLayout.WEST, purchasePnl);
		purchasePnl.add(purchaseLottoTfPnl);
		SpringLayout sl_purchaseLottoTfPnl = new SpringLayout();
		purchaseLottoTfPnl.setLayout(sl_purchaseLottoTfPnl);

		purchaseLottoTf_1 = new JTextField();
		purchaseLottoTf_1.setHorizontalAlignment(SwingConstants.CENTER);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.NORTH, purchaseLottoTf_1, 9, SpringLayout.NORTH,
				purchaseLottoTfPnl);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.WEST, purchaseLottoTf_1, 8, SpringLayout.WEST,
				purchaseLottoTfPnl);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.SOUTH, purchaseLottoTf_1, 44, SpringLayout.NORTH,
				purchaseLottoTfPnl);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.EAST, purchaseLottoTf_1, 43, SpringLayout.WEST,
				purchaseLottoTfPnl);
		purchaseLottoTf_1.setColumns(10);

		purchaseLottoTf_2 = new JTextField();
		purchaseLottoTf_2.setHorizontalAlignment(SwingConstants.CENTER);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.NORTH, purchaseLottoTf_2, 0, SpringLayout.NORTH,
				purchaseLottoTf_1);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.WEST, purchaseLottoTf_2, 27, SpringLayout.EAST,
				purchaseLottoTf_1);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.SOUTH, purchaseLottoTf_2, 44, SpringLayout.NORTH,
				purchaseLottoTfPnl);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.EAST, purchaseLottoTf_2, -254, SpringLayout.EAST,
				purchaseLottoTfPnl);
		purchaseLottoTf_2.setColumns(10);

		purchaseLottoTf_3 = new JTextField();
		purchaseLottoTf_3.setHorizontalAlignment(SwingConstants.CENTER);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.NORTH, purchaseLottoTf_3, 0, SpringLayout.NORTH,
				purchaseLottoTf_1);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.WEST, purchaseLottoTf_3, 25, SpringLayout.EAST,
				purchaseLottoTf_2);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.SOUTH, purchaseLottoTf_3, 44, SpringLayout.NORTH,
				purchaseLottoTfPnl);
		purchaseLottoTf_3.setColumns(10);

		purchaseLottoTf_4 = new JTextField();
		purchaseLottoTf_4.setHorizontalAlignment(SwingConstants.CENTER);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.EAST, purchaseLottoTf_3, -27, SpringLayout.WEST,
				purchaseLottoTf_4);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.WEST, purchaseLottoTf_4, 192, SpringLayout.WEST,
				purchaseLottoTfPnl);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.SOUTH, purchaseLottoTf_4, 44, SpringLayout.NORTH,
				purchaseLottoTfPnl);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.NORTH, purchaseLottoTf_4, 0, SpringLayout.NORTH,
				purchaseLottoTf_1);
		purchaseLottoTf_4.setColumns(10);

		purchaseLottoTf_5 = new JTextField();
		purchaseLottoTf_5.setHorizontalAlignment(SwingConstants.CENTER);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.SOUTH, purchaseLottoTf_5, 44, SpringLayout.NORTH,
				purchaseLottoTfPnl);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.EAST, purchaseLottoTf_4, -27, SpringLayout.WEST,
				purchaseLottoTf_5);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.NORTH, purchaseLottoTf_5, 0, SpringLayout.NORTH,
				purchaseLottoTf_1);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.WEST, purchaseLottoTf_5, 254, SpringLayout.WEST,
				purchaseLottoTfPnl);
		purchaseLottoTf_5.setColumns(10);

		purchaseLottoTf_6 = new JTextField();
		purchaseLottoTf_6.setHorizontalAlignment(SwingConstants.CENTER);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.EAST, purchaseLottoTf_5, -25, SpringLayout.WEST,
				purchaseLottoTf_6);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.SOUTH, purchaseLottoTf_6, 44, SpringLayout.NORTH,
				purchaseLottoTfPnl);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.NORTH, purchaseLottoTf_6, 0, SpringLayout.NORTH,
				purchaseLottoTf_1);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.WEST, purchaseLottoTf_6, 314, SpringLayout.WEST,
				purchaseLottoTfPnl);
		sl_purchaseLottoTfPnl.putConstraint(SpringLayout.EAST, purchaseLottoTf_6, -10, SpringLayout.EAST,
				purchaseLottoTfPnl);
		purchaseLottoTf_6.setColumns(10);

//		// 텍스트 필드에 포커스리스너 삽입(미사용)
//		textField.addFocusListener(tfFocus);
//		textField_1.addFocusListener(tfFocus);
//		textField_2.addFocusListener(tfFocus);
//		textField_3.addFocusListener(tfFocus);
//		textField_4.addFocusListener(tfFocus);
//		textField_5.addFocusListener(tfFocus);

		purchaseLottoTfPnl.add(purchaseLottoTf_1);
		purchaseLottoTfPnl.add(purchaseLottoTf_2);
		purchaseLottoTfPnl.add(purchaseLottoTf_3);
		purchaseLottoTfPnl.add(purchaseLottoTf_4);
		purchaseLottoTfPnl.add(purchaseLottoTf_5);
		purchaseLottoTfPnl.add(purchaseLottoTf_6);

		JPanel purchaseLottoBtnPnl = new JPanel();
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseLottoTfPnl, -9, SpringLayout.NORTH,
				purchaseLottoBtnPnl);
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseLottoBtnPnl, 474, SpringLayout.NORTH, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseLottoBtnPnl, -15, SpringLayout.SOUTH, purchasePnl);
		purchaseLottoBtnPnl.setBackground(Color.WHITE);
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseLottoBtnPnl, 21, SpringLayout.WEST, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseLottoBtnPnl, 380, SpringLayout.WEST, purchasePnl);
		purchasePnl.add(purchaseLottoBtnPnl);

		JButton purchaseResetBtn = new JButton("");
		purchaseResetBtn.setBorder(null);
		purchaseResetBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uB9AC\uC14B \uBC84\uD2BC.png")));
		purchaseResetBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/리셋 버튼누름.png")));
		purchaseResetBtn.setFont(new Font("굴림", Font.PLAIN, 16));
		purchaseResetBtn.addActionListener(btnAction_reset);
		SpringLayout sl_purchaseLottoBtnPnl = new SpringLayout();
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.NORTH, purchaseResetBtn, 10, SpringLayout.NORTH,
				purchaseLottoBtnPnl);
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.WEST, purchaseResetBtn, 18, SpringLayout.WEST,
				purchaseLottoBtnPnl);
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.SOUTH, purchaseResetBtn, 56, SpringLayout.NORTH,
				purchaseLottoBtnPnl);
		purchaseLottoBtnPnl.setLayout(sl_purchaseLottoBtnPnl);
		purchaseLottoBtnPnl.add(purchaseResetBtn);

		JButton purchaseAutoBtn = new JButton("");
		purchaseAutoBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uC790\uB3D9 \uBC84\uD2BC.png")));
		purchaseAutoBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/자동 버튼누름.png")));
		purchaseAutoBtn.setBorder(null);
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.NORTH, purchaseAutoBtn, 10, SpringLayout.NORTH,
				purchaseLottoBtnPnl);
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.EAST, purchaseResetBtn, -13, SpringLayout.WEST,
				purchaseAutoBtn);
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.WEST, purchaseAutoBtn, 132, SpringLayout.WEST,
				purchaseLottoBtnPnl);
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.EAST, purchaseAutoBtn, -131, SpringLayout.EAST,
				purchaseLottoBtnPnl);
		purchaseAutoBtn.setFont(new Font("굴림", Font.PLAIN, 16));
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.SOUTH, purchaseAutoBtn, 56, SpringLayout.NORTH,
				purchaseLottoBtnPnl);
		purchaseAutoBtn.addActionListener(btnAction_auto);
		purchaseLottoBtnPnl.add(purchaseAutoBtn);

		purchaseConfirmBtn = new JButton("");
		purchaseConfirmBtn.setBorder(null);
		purchaseConfirmBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uD655\uC815 \uBC84\uD2BC.png")));
		purchaseConfirmBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/확정 버튼누름.png")));
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.NORTH, purchaseConfirmBtn, 10, SpringLayout.NORTH,
				purchaseLottoBtnPnl);
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.WEST, purchaseConfirmBtn, 12, SpringLayout.EAST,
				purchaseAutoBtn);
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.SOUTH, purchaseConfirmBtn, 56, SpringLayout.NORTH,
				purchaseLottoBtnPnl);
		sl_purchaseLottoBtnPnl.putConstraint(SpringLayout.EAST, purchaseConfirmBtn, -22, SpringLayout.EAST,
				purchaseLottoBtnPnl);
		purchaseConfirmBtn.setFont(new Font("굴림", Font.PLAIN, 16));
		purchaseConfirmBtn.addActionListener(btnAction_confirm);
		panel.setFocusable(true);
		panel.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (isShowPurchasePnl) {
					if (e.getKeyCode() == KeyEvent.VK_A) {
						purchaseConfirmBtn.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_S) {
						purchaseBuyBtn.doClick();
					}
					if (e.getKeyCode() == KeyEvent.VK_D) {
						purchaseConfirmBtn.doClick();
						purchaseBuyBtn.doClick();
						purchaseConfirmBtn.doClick();
						purchaseBuyBtn.doClick();
						purchaseConfirmBtn.doClick();
						purchaseBuyBtn.doClick();
						purchaseConfirmBtn.doClick();
						purchaseBuyBtn.doClick();
						purchaseConfirmBtn.doClick();
						purchaseBuyBtn.doClick();
					}
				}
			}

		});
		purchaseLottoBtnPnl.add(purchaseConfirmBtn);

		JPanel purchaseConfirmedPnl_1 = new JPanel();
		purchaseConfirmedPnl_1.setOpaque(false);
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseConfirmedPnl_1, 45, SpringLayout.EAST,
				purchaseLottoRdbPnl);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseConfirmedPnl_1, -32, SpringLayout.EAST, purchasePnl);
		purchaseConfirmedPnl_1.setBackground(Color.WHITE);
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseConfirmedPnl_1, 29, SpringLayout.NORTH, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseConfirmedPnl_1, 86, SpringLayout.NORTH, purchasePnl);
		purchasePnl.add(purchaseConfirmedPnl_1);
		SpringLayout sl_purchaseConfirmedPnl_1 = new SpringLayout();
		purchaseConfirmedPnl_1.setLayout(sl_purchaseConfirmedPnl_1);

		JLabel purchaseConfirmedLbl_1_1 = new JLabel("45");
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_1_1, 10, SpringLayout.NORTH,
				purchaseConfirmedPnl_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_1_1, 26, SpringLayout.WEST,
				purchaseConfirmedPnl_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_1_1, 47, SpringLayout.NORTH,
				purchaseConfirmedPnl_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_1_1, 63, SpringLayout.WEST,
				purchaseConfirmedPnl_1);
		purchaseConfirmedLbl_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedLbl_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedPnl_1.add(purchaseConfirmedLbl_1_1);

		JLabel purchaseConfirmedLbl_1_2 = new JLabel("45");
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_1_2, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_1_2, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_1_2, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_1_2, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_1_1);
		purchaseConfirmedLbl_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_1_2.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_1.add(purchaseConfirmedLbl_1_2);

		JLabel purchaseConfirmedLbl_1_3 = new JLabel("45");
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_1_3, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_1_3, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_1_2);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_1_3, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_1_3, 42, SpringLayout.EAST,
				purchaseConfirmedLbl_1_2);
		purchaseConfirmedLbl_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_1_3.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_1.add(purchaseConfirmedLbl_1_3);

		JLabel purchaseConfirmedLbl_1_4 = new JLabel("45");
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_1_4, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_1_4, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_1_3);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_1_4, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_1_4, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_1_3);
		purchaseConfirmedLbl_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_1_4.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_1.add(purchaseConfirmedLbl_1_4);

		JLabel purchaseConfirmedLbl_1_5 = new JLabel("45");
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_1_5, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_1_5, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_1_4);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_1_5, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_1_5, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_1_4);
		purchaseConfirmedLbl_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_1_5.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_1.add(purchaseConfirmedLbl_1_5);

		JLabel purchaseConfirmedLbl_1_6 = new JLabel("45");
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_1_6, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_1_6, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_1_5);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_1_6, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_1_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_1_6, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_1_5);
		purchaseConfirmedLbl_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_1_6.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_1.add(purchaseConfirmedLbl_1_6);

		JButton purchaseConfirmedResetBtn_1 = new JButton("");
		purchaseConfirmedResetBtn_1
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uCD08\uAE30\uD654 \uBC84\uD2BC.png")));
		purchaseConfirmedResetBtn_1.setBorder(null);
		purchaseConfirmedResetBtn_1.setActionCommand("1");
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.NORTH, purchaseConfirmedResetBtn_1, 17, SpringLayout.NORTH,
				purchaseConfirmedPnl_1);
		sl_purchaseConfirmedPnl_1.putConstraint(SpringLayout.EAST, purchaseConfirmedResetBtn_1, -10, SpringLayout.EAST,
				purchaseConfirmedPnl_1);
		purchaseConfirmedResetBtn_1.addActionListener(btnAction_delete);
		purchaseConfirmedPnl_1.add(purchaseConfirmedResetBtn_1);

		JPanel purchaseConfirmedPnl_2 = new JPanel();
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseConfirmedPnl_2, 26, SpringLayout.SOUTH,
				purchaseConfirmedPnl_1);
		purchaseConfirmedPnl_2.setOpaque(false);
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseConfirmedPnl_2, 45, SpringLayout.EAST,
				purchaseLottoRdbPnl);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseConfirmedPnl_2, -32, SpringLayout.EAST, purchasePnl);
		purchaseConfirmedPnl_2.setBackground(Color.WHITE);
		purchasePnl.add(purchaseConfirmedPnl_2);
		SpringLayout sl_purchaseConfirmedPnl_2 = new SpringLayout();
		purchaseConfirmedPnl_2.setLayout(sl_purchaseConfirmedPnl_2);

		JLabel purchaseConfirmedLbl_2_1 = new JLabel("45");
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_2_1, 10, SpringLayout.NORTH,
				purchaseConfirmedPnl_2);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_2_1, 26, SpringLayout.WEST,
				purchaseConfirmedPnl_2);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_2_1, 47, SpringLayout.NORTH,
				purchaseConfirmedPnl_2);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_2_1, 63, SpringLayout.WEST,
				purchaseConfirmedPnl_2);
		purchaseConfirmedLbl_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_2_1.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_2.add(purchaseConfirmedLbl_2_1);

		JLabel purchaseConfirmedLbl_2_2 = new JLabel("45");
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_2_2, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_2_2, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_2_2, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_2_2, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_2_1);
		purchaseConfirmedLbl_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_2_2.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_2.add(purchaseConfirmedLbl_2_2);

		JLabel purchaseConfirmedLbl_2_3 = new JLabel("45");
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_2_3, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_2_3, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_2_2);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_2_3, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_2_3, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_2_2);
		purchaseConfirmedLbl_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_2_3.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_2.add(purchaseConfirmedLbl_2_3);

		JLabel purchaseConfirmedLbl_2_4 = new JLabel("45");
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_2_4, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_2_4, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_2_3);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_2_4, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_2_4, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_2_3);
		purchaseConfirmedLbl_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_2_4.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_2.add(purchaseConfirmedLbl_2_4);

		JLabel purchaseConfirmedLbl_2_5 = new JLabel("45");
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_2_5, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_2_5, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_2_4);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_2_5, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_2_5, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_2_4);
		purchaseConfirmedLbl_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_2_5.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_2.add(purchaseConfirmedLbl_2_5);

		JLabel purchaseConfirmedLbl_2_6 = new JLabel("45");
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_2_6, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_2_6, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_2_5);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_2_6, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_2_6, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_2_5);
		purchaseConfirmedLbl_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_2_6.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_2.add(purchaseConfirmedLbl_2_6);

		JButton purchaseConfirmedResetBtn_2 = new JButton("");
		purchaseConfirmedResetBtn_2.setBorder(null);
		purchaseConfirmedResetBtn_2
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uCD08\uAE30\uD654 \uBC84\uD2BC.png")));
		purchaseConfirmedResetBtn_2.setActionCommand("2");
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.NORTH, purchaseConfirmedResetBtn_2, 7, SpringLayout.NORTH,
				purchaseConfirmedLbl_2_1);
		sl_purchaseConfirmedPnl_2.putConstraint(SpringLayout.EAST, purchaseConfirmedResetBtn_2, -10, SpringLayout.EAST,
				purchaseConfirmedPnl_2);
		purchaseConfirmedResetBtn_2.addActionListener(btnAction_delete);
		purchaseConfirmedPnl_2.add(purchaseConfirmedResetBtn_2);

		JPanel purchaseConfirmedPnl_3 = new JPanel();
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseConfirmedPnl_2, -29, SpringLayout.NORTH,
				purchaseConfirmedPnl_3);
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseConfirmedPnl_3, 201, SpringLayout.NORTH, purchasePnl);
		purchaseConfirmedPnl_3.setOpaque(false);
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseConfirmedPnl_3, 45, SpringLayout.EAST,
				purchaseLottoRdbPnl);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseConfirmedPnl_3, -32, SpringLayout.EAST, purchasePnl);
		purchaseConfirmedPnl_3.setBackground(Color.WHITE);
		purchasePnl.add(purchaseConfirmedPnl_3);
		SpringLayout sl_purchaseConfirmedPnl_3 = new SpringLayout();
		purchaseConfirmedPnl_3.setLayout(sl_purchaseConfirmedPnl_3);

		JLabel purchaseConfirmedLbl_3_1 = new JLabel("45");
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_3_1, 10, SpringLayout.NORTH,
				purchaseConfirmedPnl_3);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_3_1, 26, SpringLayout.WEST,
				purchaseConfirmedPnl_3);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_3_1, 47, SpringLayout.NORTH,
				purchaseConfirmedPnl_3);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_3_1, 63, SpringLayout.WEST,
				purchaseConfirmedPnl_3);
		purchaseConfirmedLbl_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_3_1.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_3.add(purchaseConfirmedLbl_3_1);

		JLabel purchaseConfirmedLbl_3_2 = new JLabel("45");
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_3_2, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_3_2, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_3_2, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_3_2, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_3_1);
		purchaseConfirmedLbl_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_3_2.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_3.add(purchaseConfirmedLbl_3_2);

		JLabel purchaseConfirmedLbl_3_3 = new JLabel("45");
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_3_3, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_3_3, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_3_2);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_3_3, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_3_3, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_3_2);
		purchaseConfirmedLbl_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_3_3.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_3.add(purchaseConfirmedLbl_3_3);

		JLabel purchaseConfirmedLbl_3_4 = new JLabel("45");
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_3_4, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_3_4, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_3_3);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_3_4, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_3_4, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_3_3);
		purchaseConfirmedLbl_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_3_4.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_3.add(purchaseConfirmedLbl_3_4);

		JLabel purchaseConfirmedLbl_3_5 = new JLabel("45");
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_3_5, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_3_5, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_3_4);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_3_5, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_3_5, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_3_4);
		purchaseConfirmedLbl_3_5.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_3_5.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_3.add(purchaseConfirmedLbl_3_5);

		JLabel purchaseConfirmedLbl_3_6 = new JLabel("45");
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_3_6, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_3_6, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_3_5);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_3_6, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_3_6, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_3_5);
		purchaseConfirmedLbl_3_6.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_3_6.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_3.add(purchaseConfirmedLbl_3_6);

		JButton purchaseConfirmedResetBtn_3 = new JButton("");
		purchaseConfirmedResetBtn_3
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uCD08\uAE30\uD654 \uBC84\uD2BC.png")));
		purchaseConfirmedResetBtn_3.setBorder(null);
		purchaseConfirmedResetBtn_3.setActionCommand("3");
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.NORTH, purchaseConfirmedResetBtn_3, 7, SpringLayout.NORTH,
				purchaseConfirmedLbl_3_1);
		sl_purchaseConfirmedPnl_3.putConstraint(SpringLayout.EAST, purchaseConfirmedResetBtn_3, -10, SpringLayout.EAST,
				purchaseConfirmedPnl_3);
		purchaseConfirmedResetBtn_3.addActionListener(btnAction_delete);
		purchaseConfirmedPnl_3.add(purchaseConfirmedResetBtn_3);

		JPanel purchaseConfirmedPnl_4 = new JPanel();
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseConfirmedPnl_3, -29, SpringLayout.NORTH,
				purchaseConfirmedPnl_4);
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseConfirmedPnl_4, 293, SpringLayout.NORTH, purchasePnl);
		purchaseConfirmedPnl_4.setOpaque(false);
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseConfirmedPnl_4, 45, SpringLayout.EAST,
				purchaseLottoRdbPnl);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseConfirmedPnl_4, -32, SpringLayout.EAST, purchasePnl);
		purchaseConfirmedPnl_4.setBackground(Color.WHITE);
		purchasePnl.add(purchaseConfirmedPnl_4);
		SpringLayout sl_purchaseConfirmedPnl_4 = new SpringLayout();
		purchaseConfirmedPnl_4.setLayout(sl_purchaseConfirmedPnl_4);

		JLabel purchaseConfirmedLbl_4_1 = new JLabel("45");
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_4_1, 10, SpringLayout.NORTH,
				purchaseConfirmedPnl_4);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_4_1, 26, SpringLayout.WEST,
				purchaseConfirmedPnl_4);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_4_1, 47, SpringLayout.NORTH,
				purchaseConfirmedPnl_4);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_4_1, 62, SpringLayout.WEST,
				purchaseConfirmedPnl_4);
		purchaseConfirmedLbl_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_4_1.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_4.add(purchaseConfirmedLbl_4_1);

		JLabel purchaseConfirmedLbl_4_2 = new JLabel("45");
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_4_2, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_4_2, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_4_2, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_4_2, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_4_1);
		purchaseConfirmedLbl_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_4_2.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_4.add(purchaseConfirmedLbl_4_2);

		JLabel purchaseConfirmedLbl_4_3 = new JLabel("45");
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_4_3, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_4_3, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_4_2);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_4_3, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_4_3, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_4_2);
		purchaseConfirmedLbl_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_4_3.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_4.add(purchaseConfirmedLbl_4_3);

		JLabel purchaseConfirmedLbl_4_4 = new JLabel("45");
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_4_4, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_4_4, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_4_3);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_4_4, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_4_4, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_4_3);
		purchaseConfirmedLbl_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_4_4.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_4.add(purchaseConfirmedLbl_4_4);

		JLabel purchaseConfirmedLbl_4_5 = new JLabel("45");
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_4_5, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_4_5, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_4_4);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_4_5, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_4_5, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_4_4);
		purchaseConfirmedLbl_4_5.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_4_5.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_4.add(purchaseConfirmedLbl_4_5);

		JLabel purchaseConfirmedLbl_4_6 = new JLabel("45");
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_4_6, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_4_6, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_4_5);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_4_6, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_4_6, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_4_5);
		purchaseConfirmedLbl_4_6.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_4_6.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_4.add(purchaseConfirmedLbl_4_6);

		JButton purchaseConfirmedResetBtn_4 = new JButton("");
		purchaseConfirmedResetBtn_4.setBorder(null);
		purchaseConfirmedResetBtn_4
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uCD08\uAE30\uD654 \uBC84\uD2BC.png")));
		purchaseConfirmedResetBtn_4.setActionCommand("4");
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.NORTH, purchaseConfirmedResetBtn_4, 7, SpringLayout.NORTH,
				purchaseConfirmedLbl_4_1);
		sl_purchaseConfirmedPnl_4.putConstraint(SpringLayout.EAST, purchaseConfirmedResetBtn_4, -10, SpringLayout.EAST,
				purchaseConfirmedPnl_4);
		purchaseConfirmedResetBtn_4.addActionListener(btnAction_delete);
		purchaseConfirmedPnl_4.add(purchaseConfirmedResetBtn_4);

		JPanel purchaseConfirmedPnl_5 = new JPanel();
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseConfirmedPnl_4, -29, SpringLayout.NORTH,
				purchaseConfirmedPnl_5);
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseConfirmedPnl_5, 380, SpringLayout.NORTH, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseConfirmedPnl_5, 438, SpringLayout.NORTH, purchasePnl);
		purchaseConfirmedPnl_5.setOpaque(false);
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseConfirmedPnl_5, 45, SpringLayout.EAST,
				purchaseLottoRdbPnl);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseConfirmedPnl_5, -32, SpringLayout.EAST, purchasePnl);
		purchaseConfirmedPnl_5.setBackground(Color.WHITE);
		purchasePnl.add(purchaseConfirmedPnl_5);
		SpringLayout sl_purchaseConfirmedPnl_5 = new SpringLayout();
		purchaseConfirmedPnl_5.setLayout(sl_purchaseConfirmedPnl_5);

		JLabel purchaseConfirmedLbl_5_1 = new JLabel("45");
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_5_1, 10, SpringLayout.NORTH,
				purchaseConfirmedPnl_5);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_5_1, 25, SpringLayout.WEST,
				purchaseConfirmedPnl_5);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_5_1, 47, SpringLayout.NORTH,
				purchaseConfirmedPnl_5);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_5_1, 62, SpringLayout.WEST,
				purchaseConfirmedPnl_5);
		purchaseConfirmedLbl_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_5_1.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_5.add(purchaseConfirmedLbl_5_1);

		JLabel purchaseConfirmedLbl_5_2 = new JLabel("45");
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_5_2, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_5_2, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_5_2, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_5_2, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_5_1);
		purchaseConfirmedLbl_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_5_2.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_5.add(purchaseConfirmedLbl_5_2);

		JLabel purchaseConfirmedLbl_5_3 = new JLabel("45");
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_5_3, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_5_3, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_5_2);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_5_3, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_5_3, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_5_2);
		purchaseConfirmedLbl_5_3.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_5_3.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_5.add(purchaseConfirmedLbl_5_3);

		JLabel purchaseConfirmedLbl_5_4 = new JLabel("45");
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_5_4, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_5_4, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_5_3);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_5_4, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_5_4, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_5_3);
		purchaseConfirmedLbl_5_4.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_5_4.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_5.add(purchaseConfirmedLbl_5_4);

		JLabel purchaseConfirmedLbl_5_5 = new JLabel("45");
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_5_5, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_5_5, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_5_4);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_5_5, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_5_5, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_5_4);
		purchaseConfirmedLbl_5_5.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_5_5.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_5.add(purchaseConfirmedLbl_5_5);

		JLabel purchaseConfirmedLbl_5_6 = new JLabel("45");
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.NORTH, purchaseConfirmedLbl_5_6, 0, SpringLayout.NORTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.WEST, purchaseConfirmedLbl_5_6, 6, SpringLayout.EAST,
				purchaseConfirmedLbl_5_5);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.SOUTH, purchaseConfirmedLbl_5_6, 0, SpringLayout.SOUTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.EAST, purchaseConfirmedLbl_5_6, 43, SpringLayout.EAST,
				purchaseConfirmedLbl_5_5);
		purchaseConfirmedLbl_5_6.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseConfirmedLbl_5_6.setFont(new Font("굴림", Font.PLAIN, 15));
		purchaseConfirmedPnl_5.add(purchaseConfirmedLbl_5_6);

		JButton purchaseConfirmedResetBtn_5 = new JButton("");
		purchaseConfirmedResetBtn_5
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uCD08\uAE30\uD654 \uBC84\uD2BC.png")));
		purchaseConfirmedResetBtn_5.setBorder(null);
		purchaseConfirmedResetBtn_5.setActionCommand("5");
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.NORTH, purchaseConfirmedResetBtn_5, 7, SpringLayout.NORTH,
				purchaseConfirmedLbl_5_1);
		sl_purchaseConfirmedPnl_5.putConstraint(SpringLayout.EAST, purchaseConfirmedResetBtn_5, -10, SpringLayout.EAST,
				purchaseConfirmedPnl_5);
		purchaseConfirmedResetBtn_5.addActionListener(btnAction_delete);
		purchaseConfirmedPnl_5.add(purchaseConfirmedResetBtn_5);

		purchaseMoneyLbl = new JLabel("\uC794\uC561 : 0");
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseMoneyLbl, 0, SpringLayout.WEST, purchaseConfirmedPnl_5);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseMoneyLbl, 175, SpringLayout.EAST, purchaseLottoBtnPnl);
		purchaseMoneyLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseMoneyLbl, 10, SpringLayout.NORTH, purchaseLottoBtnPnl);
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseMoneyLbl, 56, SpringLayout.NORTH, purchaseLottoBtnPnl);
		purchaseMoneyLbl.setFont(new Font("굴림", Font.PLAIN, 18));
		purchasePnl.add(purchaseMoneyLbl);

		purchaseBuyBtn = new JButton("");
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseBuyBtn, 33, SpringLayout.EAST, purchaseMoneyLbl);
		purchaseBuyBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uACB0\uC81C \uBC84\uD2BC.png")));
		purchaseBuyBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/결제 버튼누름.png")));
		purchaseBuyBtn.setBorder(null);
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseBuyBtn, 10, SpringLayout.NORTH, purchaseLottoBtnPnl);
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseBuyBtn, 56, SpringLayout.NORTH, purchaseLottoBtnPnl);
		purchaseBuyBtn.setFont(new Font("굴림", Font.PLAIN, 18));
		purchaseBuyBtn.addActionListener(btnAction_purchase);
		purchasePnl.add(purchaseBuyBtn);

		JButton purchaseExitBtn = new JButton("");
		purchaseExitBtn.setIgnoreRepaint(true);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseBuyBtn, -18, SpringLayout.WEST, purchaseExitBtn);
		purchaseExitBtn.setBorder(null);
		purchaseExitBtn
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uB4A4\uB85C\uAC00\uAE30 \uBC84\uD2BC.png")));
		purchaseExitBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/뒤로가기 버튼누름.png")));
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseExitBtn, 10, SpringLayout.NORTH, purchaseLottoBtnPnl);
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseExitBtn, 56, SpringLayout.NORTH, purchaseLottoBtnPnl);
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseExitBtn, 724, SpringLayout.WEST, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseExitBtn, -32, SpringLayout.EAST, purchasePnl);
		purchaseExitBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				function.exitPurchase();
				mainMoneyLbl.setText(String.valueOf(loggedInUser.getSeedmoney()) + "원");
				card.show(panel, "메인창");
				isShowPurchasePnl = false;
			}
		});
		purchaseExitBtn.setFont(new Font("굴림", Font.PLAIN, 18));
		purchasePnl.add(purchaseExitBtn);

		JPanel resultPnl = new JPanel();
		panel.add(resultPnl, "결과창");
		SpringLayout sl_resultPnl = new SpringLayout();
		resultPnl.setLayout(sl_resultPnl);

		sl_resultPnl.putConstraint(SpringLayout.WEST, resultDisplayPnl, 78, SpringLayout.WEST, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.SOUTH, resultDisplayPnl, -55, SpringLayout.SOUTH, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.EAST, resultDisplayPnl, -274, SpringLayout.EAST, resultPnl);
		resultPnl.add(resultDisplayPnl);

		JPanel resultWinNumberPnl = new JPanel();
		resultWinNumberPnl.setBackground(Color.WHITE);
		sl_resultPnl.putConstraint(SpringLayout.WEST, resultWinNumberPnl, 78, SpringLayout.WEST, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.EAST, resultWinNumberPnl, -274, SpringLayout.EAST, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.NORTH, resultDisplayPnl, 19, SpringLayout.SOUTH, resultWinNumberPnl);

		sl_resultPnl.putConstraint(SpringLayout.NORTH, resultWinNumberPnl, 34, SpringLayout.NORTH, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.SOUTH, resultWinNumberPnl, 134, SpringLayout.NORTH, resultPnl);
		resultPnl.add(resultWinNumberPnl);
		SpringLayout sl_resultWinNumberPnl = new SpringLayout();
		resultWinNumberPnl.setLayout(sl_resultWinNumberPnl);

		JLabel resultWinNumber_1 = new JLabel("45");
		sl_resultWinNumberPnl.putConstraint(SpringLayout.WEST, resultWinNumber_1, 10, SpringLayout.WEST,
				resultWinNumberPnl);
		resultWinNumber_1.setFont(new Font("굴림", Font.PLAIN, 30));
		resultWinNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.NORTH, resultWinNumber_1, 24, SpringLayout.NORTH,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.EAST, resultWinNumber_1, 65, SpringLayout.WEST,
				resultWinNumberPnl);
		resultWinNumberPnl.add(resultWinNumber_1);

		JLabel resultWinNumber_2 = new JLabel("45");
		sl_resultWinNumberPnl.putConstraint(SpringLayout.NORTH, resultWinNumber_2, 24, SpringLayout.NORTH,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.WEST, resultWinNumber_2, 6, SpringLayout.EAST,
				resultWinNumber_1);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.SOUTH, resultWinNumber_2, -21, SpringLayout.SOUTH,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.EAST, resultWinNumber_2, -396, SpringLayout.EAST,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.SOUTH, resultWinNumber_1, 0, SpringLayout.SOUTH,
				resultWinNumber_2);
		resultWinNumber_2.setFont(new Font("굴림", Font.PLAIN, 30));
		resultWinNumber_2.setHorizontalAlignment(SwingConstants.CENTER);
		resultWinNumberPnl.add(resultWinNumber_2);

		JLabel resultWinNumber_3 = new JLabel("45");
		sl_resultWinNumberPnl.putConstraint(SpringLayout.NORTH, resultWinNumber_3, 24, SpringLayout.NORTH,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.WEST, resultWinNumber_3, 132, SpringLayout.WEST,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.SOUTH, resultWinNumber_3, -21, SpringLayout.SOUTH,
				resultWinNumberPnl);
		resultWinNumber_3.setFont(new Font("굴림", Font.PLAIN, 30));
		sl_resultWinNumberPnl.putConstraint(SpringLayout.EAST, resultWinNumber_3, 61, SpringLayout.EAST,
				resultWinNumber_2);
		resultWinNumber_3.setHorizontalAlignment(SwingConstants.CENTER);
		resultWinNumberPnl.add(resultWinNumber_3);

		JLabel resultWinNumber_4 = new JLabel("45");
		sl_resultWinNumberPnl.putConstraint(SpringLayout.NORTH, resultWinNumber_4, 24, SpringLayout.NORTH,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.SOUTH, resultWinNumber_4, -21, SpringLayout.SOUTH,
				resultWinNumberPnl);
		resultWinNumber_4.setFont(new Font("굴림", Font.PLAIN, 30));
		sl_resultWinNumberPnl.putConstraint(SpringLayout.WEST, resultWinNumber_4, 6, SpringLayout.EAST,
				resultWinNumber_3);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.EAST, resultWinNumber_4, 61, SpringLayout.EAST,
				resultWinNumber_3);
		resultWinNumber_4.setHorizontalAlignment(SwingConstants.CENTER);
		resultWinNumberPnl.add(resultWinNumber_4);

		JLabel resultWinNumber_5 = new JLabel("45");
		sl_resultWinNumberPnl.putConstraint(SpringLayout.NORTH, resultWinNumber_5, 24, SpringLayout.NORTH,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.SOUTH, resultWinNumber_5, -21, SpringLayout.SOUTH,
				resultWinNumberPnl);
		resultWinNumber_5.setFont(new Font("굴림", Font.PLAIN, 30));
		sl_resultWinNumberPnl.putConstraint(SpringLayout.WEST, resultWinNumber_5, 6, SpringLayout.EAST,
				resultWinNumber_4);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.EAST, resultWinNumber_5, 61, SpringLayout.EAST,
				resultWinNumber_4);
		resultWinNumber_5.setHorizontalAlignment(SwingConstants.CENTER);
		resultWinNumberPnl.add(resultWinNumber_5);

		JLabel resultWinNumber_6 = new JLabel("45");
		sl_resultWinNumberPnl.putConstraint(SpringLayout.NORTH, resultWinNumber_6, 24, SpringLayout.NORTH,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.SOUTH, resultWinNumber_6, -21, SpringLayout.SOUTH,
				resultWinNumberPnl);
		resultWinNumber_6.setFont(new Font("굴림", Font.PLAIN, 30));
		sl_resultWinNumberPnl.putConstraint(SpringLayout.WEST, resultWinNumber_6, 6, SpringLayout.EAST,
				resultWinNumber_5);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.EAST, resultWinNumber_6, 61, SpringLayout.EAST,
				resultWinNumber_5);
		resultWinNumber_6.setHorizontalAlignment(SwingConstants.CENTER);
		resultWinNumberPnl.add(resultWinNumber_6);

		resultWinNumber_plus = new JLabel("+");
		sl_resultWinNumberPnl.putConstraint(SpringLayout.NORTH, resultWinNumber_plus, 24, SpringLayout.NORTH,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.SOUTH, resultWinNumber_plus, -21, SpringLayout.SOUTH,
				resultWinNumberPnl);
		resultWinNumber_plus.setFont(new Font("굴림", Font.BOLD, 30));
		sl_resultWinNumberPnl.putConstraint(SpringLayout.WEST, resultWinNumber_plus, 6, SpringLayout.EAST,
				resultWinNumber_6);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.EAST, resultWinNumber_plus, 61, SpringLayout.EAST,
				resultWinNumber_6);
		resultWinNumber_plus.setHorizontalAlignment(SwingConstants.CENTER);
		resultWinNumberPnl.add(resultWinNumber_plus);

		JLabel resultWinNumber_bonus = new JLabel("45");
		sl_resultWinNumberPnl.putConstraint(SpringLayout.NORTH, resultWinNumber_bonus, 24, SpringLayout.NORTH,
				resultWinNumberPnl);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.SOUTH, resultWinNumber_bonus, -21, SpringLayout.SOUTH,
				resultWinNumberPnl);
		resultWinNumber_bonus.setFont(new Font("굴림", Font.PLAIN, 30));
		sl_resultWinNumberPnl.putConstraint(SpringLayout.WEST, resultWinNumber_bonus, 6, SpringLayout.EAST,
				resultWinNumber_plus);
		sl_resultWinNumberPnl.putConstraint(SpringLayout.EAST, resultWinNumber_bonus, 61, SpringLayout.EAST,
				resultWinNumber_plus);
		resultWinNumber_bonus.setHorizontalAlignment(SwingConstants.CENTER);
		resultWinNumberPnl.add(resultWinNumber_bonus);
		sl_resultPnl.putConstraint(SpringLayout.WEST, resultExitBtn, -184, SpringLayout.EAST, resultPnl);
		resultExitBtn.setBorder(null);
		resultExitBtn
				.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uB4A4\uB85C\uAC00\uAE30 \uBC84\uD2BC.png")));
		resultExitBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/뒤로가기 버튼누름 to 구매내역.png")));
		sl_resultPnl.putConstraint(SpringLayout.NORTH, resultExitBtn, -100, SpringLayout.SOUTH, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.SOUTH, resultExitBtn, -50, SpringLayout.SOUTH, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.EAST, resultExitBtn, -50, SpringLayout.EAST, resultPnl);
		resultExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblIndex == 7) {
					for (JLabel resultLbl : lblList) {
						resultLbl.setVisible(false);
					}
					resultWinNumber_plus.setVisible(false);
					lblIndex = 0;
					resultSummuryBtn.setVisible(false);
					resultTotalBtn.setVisible(false);
					lottoProgram.endDrawLotto();
				}
				cl_resultDisplayPnl.show(resultDisplayPnl, "gif창");
				card.show(panel, "메인창");
			}
		});
		resultExitBtn.setFont(new Font("굴림", Font.PLAIN, 18));
		resultPnl.add(resultExitBtn);

		resultDisplayPnl.setLayout(cl_resultDisplayPnl);

		resultDrawPnl = new JPanel();
		resultDrawPnl.setBackground(Color.WHITE);
		resultDisplayPnl.add(resultDrawPnl, "gif창");

		JLabel resultDrawGifLbl = new JLabel("");
		resultDrawGifLbl.addMouseListener(lblGifMouseAdapter);
		SpringLayout sl_resultDrawPnl = new SpringLayout();
		sl_resultDrawPnl.putConstraint(SpringLayout.NORTH, resultDrawGifLbl, 0, SpringLayout.NORTH, resultDrawPnl);
		sl_resultDrawPnl.putConstraint(SpringLayout.WEST, resultDrawGifLbl, 0, SpringLayout.WEST, resultDrawPnl);
		sl_resultDrawPnl.putConstraint(SpringLayout.SOUTH, resultDrawGifLbl, 270, SpringLayout.NORTH, resultDrawPnl);
		sl_resultDrawPnl.putConstraint(SpringLayout.EAST, resultDrawGifLbl, 522, SpringLayout.WEST, resultDrawPnl);
		resultDrawPnl.setLayout(sl_resultDrawPnl);

		resultDrawGifLbl.setBackground(Color.WHITE);
		resultDrawGifLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultDrawGifLbl.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/lottoResultLbl.gif")));
		resultDrawPnl.add(resultDrawGifLbl);

		JLabel resultDrawClickmeLbl = new JLabel("");
		resultDrawClickmeLbl.addMouseListener(lblClkmeMouseAdapter);
		sl_resultDrawPnl.putConstraint(SpringLayout.NORTH, resultDrawClickmeLbl, -70, SpringLayout.SOUTH,
				resultDrawPnl);
		sl_resultDrawPnl.putConstraint(SpringLayout.WEST, resultDrawClickmeLbl, 170, SpringLayout.WEST, resultDrawPnl);
		sl_resultDrawPnl.putConstraint(SpringLayout.SOUTH, resultDrawClickmeLbl, 0, SpringLayout.SOUTH, resultDrawPnl);
		sl_resultDrawPnl.putConstraint(SpringLayout.EAST, resultDrawClickmeLbl, 330, SpringLayout.WEST, resultDrawPnl);
		resultDrawClickmeLbl.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uD074\uB9AD \uBC84\uD2BC.png")));
		resultDrawClickmeLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultDrawPnl.add(resultDrawClickmeLbl);
		resultWinListPnl.setBackground(Color.WHITE);

		resultTotalListPnl.setSize(new Dimension(522, 351));
		resultTotalListPnl.setLayout(new GridLayout(0, 1, 0, 0));
		resultTotalScroll.setBackground(Color.WHITE);
		resultWinScroll.setBackground(Color.WHITE);
		resultDisplayPnl.setBackground(Color.WHITE);
		resultDisplayPnl.add(resultTotalScroll, "결과창");

		resultWinListPnl.setSize(new Dimension(522, 351));
		resultWinListPnl.setLayout(new GridLayout(0, 1, 0, 0));
		resultDisplayPnl.add(resultWinScroll, "요약결과창");

		resultDisplayPnl.setBackground(Color.WHITE);

		resultSummuryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_resultDisplayPnl.show(resultDisplayPnl, "요약결과창");
				resultSummuryBtn.setVisible(false);
				resultTotalBtn.setVisible(true);

			}
		});
		sl_resultPnl.putConstraint(SpringLayout.NORTH, resultSummuryBtn, -240, SpringLayout.SOUTH, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.WEST, resultSummuryBtn, -184, SpringLayout.EAST, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.SOUTH, resultSummuryBtn, -190, SpringLayout.SOUTH, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.EAST, resultSummuryBtn, -50, SpringLayout.EAST, resultPnl);
		resultSummuryBtn.setFont(new Font("굴림", Font.PLAIN, 18));
		resultPnl.add(resultSummuryBtn);

		resultSummuryBtn.setVisible(false);
		resultTotalBtn.setVisible(false);
		resultTotalBtn.setActionCommand("\uC694\uC57D");
		resultTotalBtn.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uC804\uCCB4 \uBC84\uD2BC.png")));
		resultTotalBtn.setBorder(null);
		sl_resultPnl.putConstraint(SpringLayout.WEST, resultTotalBtn, -184, SpringLayout.EAST, resultPnl);
		resultTotalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl_resultDisplayPnl.show(resultDisplayPnl, "결과창");
				resultTotalBtn.setVisible(false);
				resultSummuryBtn.setVisible(true);
			}
		});
		sl_resultPnl.putConstraint(SpringLayout.NORTH, resultTotalBtn, -240, SpringLayout.SOUTH, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.SOUTH, resultTotalBtn, -190, SpringLayout.SOUTH, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.EAST, resultTotalBtn, -50, SpringLayout.EAST, resultPnl);
		resultTotalBtn.setFont(new Font("굴림", Font.PLAIN, 18));
		resultPnl.add(resultTotalBtn);

		JLabel resultBackgroundLbl = new JLabel("");
		resultBackgroundLbl.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uBE48 \uD654\uBA74.png")));
		sl_resultPnl.putConstraint(SpringLayout.NORTH, resultBackgroundLbl, 0, SpringLayout.NORTH, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.WEST, resultBackgroundLbl, 0, SpringLayout.WEST, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.SOUTH, resultBackgroundLbl, 0, SpringLayout.SOUTH, resultPnl);
		sl_resultPnl.putConstraint(SpringLayout.EAST, resultBackgroundLbl, 0, SpringLayout.EAST, resultPnl);
		resultPnl.add(resultBackgroundLbl);

		radioList.add(purchaseLottoRdb_1);
		radioList.add(purchaseLottoRdb_2);
		radioList.add(purchaseLottoRdb_3);
		radioList.add(purchaseLottoRdb_4);
		radioList.add(purchaseLottoRdb_5);
		radioList.add(purchaseLottoRdb_6);
		radioList.add(purchaseLottoRdb_7);
		radioList.add(purchaseLottoRdb_8);
		radioList.add(purchaseLottoRdb_9);
		radioList.add(purchaseLottoRdb_10);
		radioList.add(purchaseLottoRdb_11);
		radioList.add(purchaseLottoRdb_12);
		radioList.add(purchaseLottoRdb_13);
		radioList.add(purchaseLottoRdb_14);
		radioList.add(purchaseLottoRdb_15);
		radioList.add(purchaseLottoRdb_16);
		radioList.add(purchaseLottoRdb_17);
		radioList.add(purchaseLottoRdb_18);
		radioList.add(purchaseLottoRdb_19);
		radioList.add(purchaseLottoRdb_20);
		radioList.add(purchaseLottoRdb_21);
		radioList.add(purchaseLottoRdb_22);
		radioList.add(purchaseLottoRdb_23);
		radioList.add(purchaseLottoRdb_24);
		radioList.add(purchaseLottoRdb_25);
		radioList.add(purchaseLottoRdb_26);
		radioList.add(purchaseLottoRdb_27);
		radioList.add(purchaseLottoRdb_28);
		radioList.add(purchaseLottoRdb_29);
		radioList.add(purchaseLottoRdb_30);
		radioList.add(purchaseLottoRdb_31);
		radioList.add(purchaseLottoRdb_32);
		radioList.add(purchaseLottoRdb_33);
		radioList.add(purchaseLottoRdb_34);
		radioList.add(purchaseLottoRdb_35);
		radioList.add(purchaseLottoRdb_36);
		radioList.add(purchaseLottoRdb_37);
		radioList.add(purchaseLottoRdb_38);
		radioList.add(purchaseLottoRdb_39);
		radioList.add(purchaseLottoRdb_40);
		radioList.add(purchaseLottoRdb_41);
		radioList.add(purchaseLottoRdb_42);
		radioList.add(purchaseLottoRdb_43);
		radioList.add(purchaseLottoRdb_44);
		radioList.add(purchaseLottoRdb_45);

		purchaseLottoTf_1.setEditable(false);
		purchaseLottoTf_2.setEditable(false);
		purchaseLottoTf_3.setEditable(false);
		purchaseLottoTf_4.setEditable(false);
		purchaseLottoTf_5.setEditable(false);
		purchaseLottoTf_6.setEditable(false);

		tfList.add(purchaseLottoTf_1);
		tfList.add(purchaseLottoTf_2);
		tfList.add(purchaseLottoTf_3);
		tfList.add(purchaseLottoTf_4);
		tfList.add(purchaseLottoTf_5);
		tfList.add(purchaseLottoTf_6);

		purchaseConfirmedPnl_1.setVisible(false);
		purchaseConfirmedPnl_2.setVisible(false);
		purchaseConfirmedPnl_3.setVisible(false);
		purchaseConfirmedPnl_4.setVisible(false);
		purchaseConfirmedPnl_5.setVisible(false);

		List<JLabel> lblList5 = new ArrayList<>(
				Arrays.asList(purchaseConfirmedLbl_1_1, purchaseConfirmedLbl_1_2, purchaseConfirmedLbl_1_3,
						purchaseConfirmedLbl_1_4, purchaseConfirmedLbl_1_5, purchaseConfirmedLbl_1_6));
		List<JLabel> lblList6 = new ArrayList<>(
				Arrays.asList(purchaseConfirmedLbl_2_1, purchaseConfirmedLbl_2_2, purchaseConfirmedLbl_2_3,
						purchaseConfirmedLbl_2_4, purchaseConfirmedLbl_2_5, purchaseConfirmedLbl_2_6));
		List<JLabel> lblList7 = new ArrayList<>(
				Arrays.asList(purchaseConfirmedLbl_3_1, purchaseConfirmedLbl_3_2, purchaseConfirmedLbl_3_3,
						purchaseConfirmedLbl_3_4, purchaseConfirmedLbl_3_5, purchaseConfirmedLbl_3_6));
		List<JLabel> lblList8 = new ArrayList<>(
				Arrays.asList(purchaseConfirmedLbl_4_1, purchaseConfirmedLbl_4_2, purchaseConfirmedLbl_4_3,
						purchaseConfirmedLbl_4_4, purchaseConfirmedLbl_4_5, purchaseConfirmedLbl_4_6));
		List<JLabel> lblList9 = new ArrayList<>(
				Arrays.asList(purchaseConfirmedLbl_5_1, purchaseConfirmedLbl_5_2, purchaseConfirmedLbl_5_3,
						purchaseConfirmedLbl_5_4, purchaseConfirmedLbl_5_5, purchaseConfirmedLbl_5_6));
		pnlMap.put(purchaseConfirmedPnl_1, lblList5);
		pnlMap.put(purchaseConfirmedPnl_2, lblList6);
		pnlMap.put(purchaseConfirmedPnl_3, lblList7);
		pnlMap.put(purchaseConfirmedPnl_4, lblList8);
		pnlMap.put(purchaseConfirmedPnl_5, lblList9);

		JLabel purchaseBackgroundLbl = new JLabel("");
		purchaseBackgroundLbl.setFocusable(true);
		purchaseBackgroundLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				purchaseBackgroundLbl.requestFocus();
			}
		});
		purchaseBackgroundLbl.setIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/\uAD6C\uB9E4 \uBC30\uACBD.png")));
		sl_purchasePnl.putConstraint(SpringLayout.NORTH, purchaseBackgroundLbl, 0, SpringLayout.NORTH, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.WEST, purchaseBackgroundLbl, 0, SpringLayout.WEST, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.SOUTH, purchaseBackgroundLbl, 0, SpringLayout.SOUTH, purchasePnl);
		sl_purchasePnl.putConstraint(SpringLayout.EAST, purchaseBackgroundLbl, 0, SpringLayout.EAST, purchasePnl);
		purchasePnl.add(purchaseBackgroundLbl);
		loginTfId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					id = loginTfId.getText();
					password = loginPwPwf.getText();
					loggedInUser = loginManager.loginCke(id, password);
					if (loggedInUser != null) {
						purchaseMoneyLbl.setText(String.valueOf(loggedInUser.getSeedmoney()) + "원");
						card.show(panel, "메인창");
						mainNameLbl.setText(loggedInUser.getName());
						loginTfId.setText("");
						loginPwPwf.setText("");
					}
				}

			}
		});

		loginPwPwf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					id = loginTfId.getText();
					password = loginPwPwf.getText();
					loggedInUser = loginManager.loginCke(id, password);
					if (loggedInUser != null) {
						card.show(panel, "메인창");
					}
				}

			}
		});

		lblList = new ArrayList<>();
		lblIndex = 0;
		lblList.add(resultWinNumber_1);
		lblList.add(resultWinNumber_2);
		lblList.add(resultWinNumber_3);
		lblList.add(resultWinNumber_4);
		lblList.add(resultWinNumber_5);
		lblList.add(resultWinNumber_6);
		lblList.add(resultWinNumber_bonus);
		resultWinNumber_1.setText("");
		resultWinNumber_2.setText("");
		resultWinNumber_3.setText("");
		resultWinNumber_4.setText("");
		resultWinNumber_5.setText("");
		resultWinNumber_6.setText("");
		resultWinNumber_bonus.setText("");

		JPanel listPnl = new JPanel();
		listPnl.setBackground(Color.WHITE);
		panel.add(listPnl, "구매내역창");
		SpringLayout sl_listPnl = new SpringLayout();
		listPnl.setLayout(sl_listPnl);

		listTotalPnl.setBackground(Color.WHITE);
		listScroll = new JScrollPane(listTotalPnl);
		sl_listPnl.putConstraint(SpringLayout.NORTH, listScroll, 20, SpringLayout.NORTH, listPnl);
		sl_listPnl.putConstraint(SpringLayout.WEST, listScroll, 70, SpringLayout.WEST, listPnl);
		sl_listPnl.putConstraint(SpringLayout.SOUTH, listScroll, -20, SpringLayout.SOUTH, listPnl);
		sl_listPnl.putConstraint(SpringLayout.EAST, listScroll, 592, SpringLayout.WEST, listPnl);
		listPnl.add(listScroll);

		JButton listExitBtn = new JButton("");
		listExitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "메인창");
			}
		});
		listExitBtn.setIcon(new ImageIcon(LottoGUI.class
				.getResource("/GUI/\uB4A4\uB85C\uAC00\uAE30 \uBC84\uD2BC to \uAD6C\uB9E4\uB0B4\uC5ED.png")));
		listExitBtn.setPressedIcon(new ImageIcon(LottoGUI.class.getResource("/GUI/뒤로가기 버튼누름.png")));
		listExitBtn.setBorder(null);
		sl_listPnl.putConstraint(SpringLayout.NORTH, listExitBtn, -110, SpringLayout.SOUTH, listPnl);
		sl_listPnl.putConstraint(SpringLayout.WEST, listExitBtn, 720, SpringLayout.WEST, listPnl);
		sl_listPnl.putConstraint(SpringLayout.SOUTH, listExitBtn, -60, SpringLayout.SOUTH, listPnl);
		sl_listPnl.putConstraint(SpringLayout.EAST, listExitBtn, -30, SpringLayout.EAST, listPnl);
		listPnl.add(listExitBtn);
		resultWinNumber_plus.setVisible(false);
		MouseAdapter frameMoveMouseAdapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				initialX = e.getX();
				initialY = e.getY();
			}
		};
		MouseMotionAdapter frameMoveMouseMotionAdapter = new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int deltaX = e.getX() - initialX;
				int deltaY = e.getY() - initialY;
				setLocation(getLocation().x + deltaX, getLocation().y + deltaY);
			}
		};
		loginPnl.addMouseListener(frameMoveMouseAdapter);
		mainPnl.addMouseListener(frameMoveMouseAdapter);
		purchaseBackgroundLbl.addMouseListener(frameMoveMouseAdapter);
		resultPnl.addMouseListener(frameMoveMouseAdapter);
		listPnl.addMouseListener(frameMoveMouseAdapter);
		loginPnl.addMouseMotionListener(frameMoveMouseMotionAdapter);
		mainPnl.addMouseMotionListener(frameMoveMouseMotionAdapter);
		purchaseBackgroundLbl.addMouseMotionListener(frameMoveMouseMotionAdapter);
		resultPnl.addMouseMotionListener(frameMoveMouseMotionAdapter);
		listPnl.addMouseMotionListener(frameMoveMouseMotionAdapter);

		listScroll.getVerticalScrollBar().setUnitIncrement(20);
		resultTotalScroll.getVerticalScrollBar().setUnitIncrement(20);
		resultWinScroll.getVerticalScrollBar().setUnitIncrement(20);

	}

	public void makeBall(int i) {
		if (drawNumberSet.size() < 6) {
			drawNumberSet.add(i);
		}
		String fileName = "/GUI/lottoNumbers/" + i + ".png";
		if (lblIndex < 6) {
			URL imgUrl = Function.class.getResource(fileName);
			lblList.get(lblIndex).setVisible(true);
			lblList.get(lblIndex).setIcon(new ImageIcon(imgUrl));
			lblList.get(lblIndex).setIconTextGap(-14);
			lblIndex++;
		} else {
			resultWinNumber_plus.setVisible(true);
			URL imgUrl = Function.class.getResource(fileName);
			lblList.get(lblIndex).setVisible(true);
			lblList.get(lblIndex).setIcon(new ImageIcon(imgUrl));
			lblList.get(lblIndex).setIconTextGap(-14);
			lblIndex++;
		}
	}

	public void drawNumberEnd() {
		List<Integer> temp = new ArrayList<>();
		for (Integer i : drawNumberSet) {
			temp.add(i);
		}
		for (int i = 0; i < 6; i++) {
			String fileName = "/GUI/lottoNumbers/" + temp.get(i) + ".png";
			URL imgUrl = Function.class.getResource(fileName);
			lblList.get(i).setIcon(new ImageIcon(imgUrl));
			lblList.get(i).setIconTextGap(-14);
		}
		drawNumberSet.clear();
	}

	public void drawNumberAuto() {
		while (lblIndex < 7) {
			makeBall(lottoProgram.makeDrawLotto());
		}
	}

	private void showSignUpDialog() {

		JDialog signUpDialog = new JDialog(this, "회원가입", true);

		JPanel panel = new JPanel(new GridLayout(4, 2));
		JLabel idLabel = new JLabel("아이디:");
		JTextField idField = new JTextField();
		JLabel passwordLabel = new JLabel("비밀번호:");
		JLabel nameLabel = new JLabel("이름:");
		JTextField nameField = new JTextField();
		JPasswordField passwordField = new JPasswordField();
		JButton signUpConfirmButton = new JButton("확인");
		Font gainFont = new Font("", Font.BOLD, 11);
		Font lostFont = new Font("", Font.BOLD, 11);
		passwordField.setLayout(new BorderLayout());
		JLabel lblNewLabel00 = new JLabel("패스워드를 입력하세요");
		passwordField.add(lblNewLabel00);
		lblNewLabel00.setFont(lostFont);
		idField.setForeground(Color.GRAY);

		// 아이디
		idField.setToolTipText("아이디를 입력하세요");
		idField.setText("아이디를 입력하세요");
		idField.setFont(lostFont);
		idField.setForeground(Color.GRAY);
		idField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (idField.getText().equals("")) {
					idField.setText("아이디를 입력하세요");
					idField.setFont(lostFont);
					idField.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (idField.getText().equals("아이디를 입력하세요")) {
					idField.setText("");
					idField.setFont(gainFont);
					idField.setForeground(Color.BLACK);
				}
			}
		});

		lblNewLabel00.setFont(lostFont);
		lblNewLabel00.setForeground(Color.GRAY);
		passwordField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().length() == 0) {
					lblNewLabel00.setVisible(true);
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				lblNewLabel00.setVisible(false);

			}
		});

		// 이름
		nameField.setToolTipText("이름을 입력하세요");
		nameField.setText("이름을 입력하세요");
		nameField.setFont(lostFont);
		nameField.setForeground(Color.GRAY);
		nameField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (nameField.getText().equals("")) {
					nameField.setText("이름을 입력하세요");
					nameField.setFont(lostFont);
					nameField.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (nameField.getText().equals("이름을 입력하세요")) {
					nameField.setText("");
					nameField.setFont(gainFont);
					nameField.setForeground(Color.BLACK);
				}
			}
		});

		signUpConfirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String name = nameField.getText();
				LottoGUI gui = returnSelf();

				int loginCode = loginManager.isCreatable(id, password, name);
				switch (loginCode) {
				case 1:
					if (id.equals("아이디를 입력하세요")) { // id 1글자 이상
						JOptionPane.showMessageDialog(null, "ID는 1글자 이상이어야 합니다.");
						break;
					}
					if (password.length() == 0) { // pw 1글자 이상
						JOptionPane.showMessageDialog(null, "PassWord는 1글자 이상이어야 합니다.");
						break;
					}
					if (name.length() > 3) { // 이름은 3글자 이내로
						JOptionPane.showMessageDialog(null, "이름은 3글자 이하여야 합니다.");
						break;
					}
					if (id.contains(" ")) { // 공백문자 사용 불가능
						JOptionPane.showMessageDialog(null, "ID에 공백문자를 사용할 수 없습니다.");
						break;
					}
					if (password.contains(" ")) { // 공백문자 사용 불가능
						JOptionPane.showMessageDialog(null, "PassWord에 공백문자를 사용할 수 없습니다.");
						break;
					}
					if (name.contains(" ")) { // 공백문자 사용 불가능
						JOptionPane.showMessageDialog(null, "이름에 공백문자를 사용할 수 없습니다.");
						break;
					}
					loginManager.createUser(id, password, name, gui);
					signUpDialog.dispose();
					break;
				case -1:
					// 회원가입 실패 : 사유 : 이미 존재하는 회원
					JOptionPane.showMessageDialog(null, "존재하는 회원입니다.");
					break;
				case -2:
					// 회원가입 실패 : 사유 : 이름 중복
					JOptionPane.showMessageDialog(null, "이미 존재하는 이름입니다.");
					break;
				case -3:
					// 회원가입 실패 : 사유 : id 중복
					JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다..");
					break;
				}
			}
		});

		KeyAdapter registerKeyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String id = idField.getText();
					String password = String.valueOf(passwordField.getPassword());
					String name = nameField.getText();
					LottoGUI gui = returnSelf();

					int loginCode = loginManager.isCreatable(id, password, name);
					switch (loginCode) {
					case 1:
						if (id.equals("아이디를 입력하세요")) { // id 한글자 이상
							JOptionPane.showMessageDialog(null, "ID는 1글자 이상이어야 합니다.");
							break;
						}
						if (password.length() == 0) { // pw 한글자 이상
							JOptionPane.showMessageDialog(null, "PassWord는 1글자 이상이어야 합니다.");
							break;
						}
						if (name.length() > 3) { // 이름 3글자 이내로
							JOptionPane.showMessageDialog(null, "이름은 3글자 이하여야 합니다.");
							break;
						}
						if (id.contains(" ")) { // 공백문자 사용 불가능
							JOptionPane.showMessageDialog(null, "ID에 공백문자를 사용할 수 없습니다.");
							break;
						}
						if (password.contains(" ")) { // 공백문자 사용 불가능
							JOptionPane.showMessageDialog(null, "PassWord에 공백문자를 사용할 수 없습니다.");
							break;
						}
						if (name.contains(" ")) { // 공백문자 사용 불가능
							JOptionPane.showMessageDialog(null, "이름에 공백문자를 사용할 수 없습니다.");
							break;
						}
						loginManager.createUser(id, password, name, gui);
						signUpDialog.dispose();
						break;
					case -1:
						// 회원가입 실패 : 사유 : 이미 존재하는 회원
						JOptionPane.showMessageDialog(null, "존재하는 회원입니다.");
						break;
					case -2:
						// 회원가입 실패 : 사유 : 이름 중복
						JOptionPane.showMessageDialog(null, "이미 존재하는 이름입니다.");
						break;
					case -3:
						// 회원가입 실패 : 사유 : id 중복
						JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다..");
						break;
					}
				}

			}
		};

		idField.addKeyListener(registerKeyAdapter);
		passwordField.addKeyListener(registerKeyAdapter);
		nameField.addKeyListener(registerKeyAdapter);

		panel.add(idLabel);
		panel.add(idField);
		panel.add(passwordLabel);
		panel.add(passwordField);
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(new JLabel()); // 빈 레이블을 추가하여 간격을 조절
		panel.add(signUpConfirmButton);

		signUpDialog.getContentPane().add(panel);
		signUpDialog.setSize(300, 150);
		signUpDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		signUpDialog.setLocationRelativeTo(this);
		signUpDialog.setVisible(true);
	}

	private void showMoneyDialog(LottoGUI gui) {
		LottoGUI thisgui = gui;
		JDialog moneyDialog = new JDialog(this, "Money Dialog", true);

		moneyDialog.getContentPane().setLayout(new FlowLayout());

		inputMoney = new JTextField("0");
		inputMoney.setPreferredSize(new Dimension(300, 40));
		inputMoney.setFont(new Font("굴림", 0, 20));
		inputMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		inputMoney.setMargin(new Insets(0, 0, 0, 10));
		inputMoney.setEditable(false);
		JButton btn1000 = new JButton("1000원");
		btn1000.setPreferredSize(new Dimension(96, 40));
		JButton btn5000 = new JButton("5000원");
		btn5000.setPreferredSize(new Dimension(98, 40));
		JButton btn10000 = new JButton("10000원");
		btn10000.setPreferredSize(new Dimension(96, 40));
		JButton btnOK = new JButton("확인");
		btnOK.setPreferredSize(new Dimension(100, 40));
		JButton btnCancel = new JButton("취소");
		btnCancel.setPreferredSize(new Dimension(100, 40));

		btn1000.addActionListener(new MoneyButtonListener(1000));
		btn5000.addActionListener(new MoneyButtonListener(5000));
		btn10000.addActionListener(new MoneyButtonListener(10000));

		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int afterMoney = loggedInUser.getSeedmoney() + Integer.valueOf(inputMoney.getText());
				if (afterMoney < 100000000) {
					loggedInUser.setSeedmoney(afterMoney);
					thisgui.purchaseLabelUpdate(afterMoney);
				}
				moneyDialog.dispose();
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moneyDialog.dispose();
			}
		});

		moneyDialog.getContentPane().add(inputMoney);
		moneyDialog.getContentPane().add(btnOK);
		moneyDialog.getContentPane().add(btn1000);
		moneyDialog.getContentPane().add(btn5000);
		moneyDialog.getContentPane().add(btn10000);
		moneyDialog.getContentPane().add(btnCancel);

		moneyDialog.setSize(450, 140);
		moneyDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		moneyDialog.setLocationRelativeTo(this);
		moneyDialog.setVisible(true);
	}

	private class MoneyButtonListener implements ActionListener {
		private int amount;

		public MoneyButtonListener(int amount) {
			this.amount = amount;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// 버튼을 눌렀을 때 텍스트 필드의 값을 가져와서 버튼의 금액을 더합니다.
			try {
				int currentMoney = Integer.parseInt(inputMoney.getText());
				currentMoney += amount;
				inputMoney.setText(String.valueOf(currentMoney));
			} catch (NumberFormatException ex) {
				// 텍스트 필드에 숫자가 아닌 값이 입력된 경우 처리할 수 있습니다.
				ex.printStackTrace();
			}
		}
	}

	public void purchaseLabelUpdate(int input) {
		purchaseMoneyLbl.setText(input + "원");
		mainMoneyLbl.setText(input + "원");
	}

	public LottoGUI returnSelf() {
		return this;
	}
}
