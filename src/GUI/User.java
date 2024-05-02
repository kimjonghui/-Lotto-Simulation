package GUI;

import java.util.ArrayList;
import java.util.List;

import number.LottoProgram;

public class User {
	private String name;
	private String id;
	private String password;
	private int seedmoney;
	private LottoProgram lotto;

	public LottoProgram getLotto() {
		return lotto;
	}

	public void setLotto(LottoProgram lotto) {
		this.lotto = lotto;
	}

	public User(String name, String id, String password, LottoGUI gui) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.seedmoney = 0;
		this.lotto = new LottoProgram(gui);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPssWord(String password) {
		this.password = password;
	}

	public boolean checkPassword(String pwdPassword) {
		return this.password.equals(pwdPassword);
	}

	public int getSeedmoney() {
		return seedmoney;
	}

	public void setSeedmoney(int seedmoney) {
		this.seedmoney = seedmoney;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", password=" + password + ", seedmoney=" + seedmoney + "]";
	}

	public static void moneyplus(User user, int input) {
		int money = user.getSeedmoney();
		money += input;
		user.setSeedmoney(money);
	}
}

class LoginManager {
	private List<User> users;

	public LoginManager() {
		users = new ArrayList<>();
		// 기본 사용자 추가
		//users.add(new User("박 민", "user", "1234"));
	}

	public User loginCke(String id, String password) {
		for (User user : users) {
			if (user.getId().equals(id) && user.checkPassword(password)) {
				return user;
			}
		}
		return null; // 사용자가 없거나 비밀번호가 일치하지 않는 경우
	}
	/**
	 * 입력받은 String값으로 회원가입이 가능한지 판단하는 메소드<br>
	 * @param id id값
	 * @param password password값
	 * @param name name값
	 * @return 생성 가능한경우, 1을 리턴<br>
	 * 둘 다 중복이라 생성이 불가능한 경우, -1을 리턴<br>
	 * name이 중복이라 생성이 불가능할 경우, -2를 리턴<br>
	 * id가 중복이라 생성이 불가능할 경우, -3을 리턴
	 */
	public int isCreatable(String id, String password, String name) {
		if(users.size() == 0) {
			return 1;
		}
		for (User user : users) {
			if (!user.getId().equals(id) && !user.getName().equals(name)) {
				return 1;
			} else if(!user.getId().equals(id) && user.getName().equals(name)) {
				return -2;
			} else if(user.getId().equals(id) && !user.getName().equals(name)) {
				return -3;
			}
		}
		return -1;
	}

	public void createUser(String id, String password, String name , LottoGUI gui) {
		users.add(new User(name, id, password, gui));
	}
}