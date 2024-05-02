package number;

import java.util.*;

public class UserLotto {
	private Set<Integer> intSet;

	public Set<Integer> getIntSet() {
		return intSet;
	}

	public void setIntSet(Set<Integer> intSet) {
		this.intSet = intSet;
	}

	public UserLotto() {
		super();
		this.intSet = new TreeSet<>();
		Random rand = new Random();
		while (intSet.size() < 6) {
			int randNum = rand.nextInt(45) + 1;
			intSet.add(randNum);
		}
	}

	public UserLotto(int i1, int i2, int i3, int i4, int i5, int i6) {
		super();
		this.intSet = new TreeSet<>();
		intSet.add(i1);
		intSet.add(i2);
		intSet.add(i3);
		intSet.add(i4);
		intSet.add(i5);
		intSet.add(i6);
	}
}
