package number;

import java.util.*;

public class DrawLotto extends UserLotto {
	private int bonusNumber;

	public DrawLotto(int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
		super(i1, i2, i3, i4, i5, i6);
		this.bonusNumber = i7;
	}

	public int getBonusNumber() {
		return bonusNumber;
	}

	public void setBonusNumber(int bonusNumber) {
		this.bonusNumber = bonusNumber;
	}
}
