package fly;

import java.util.ArrayList;
import java.util.Arrays;

public class effort {

	static boolean one_edit(String test_text, String test_text2) {
		int i = 0;
		String shorter_text = "";
		String longer_text = "";
		boolean first_edit = false;
//�� ���ڿ� ���� ���� 2 �̻��̸� false  ���ڱ��� ���ų� 1����
		if (test_text.length() > test_text2.length()) {
			shorter_text = test_text2;
			longer_text = test_text;
			if (test_text.length() - test_text2.length() > 1)
				return false;
		} else {
			shorter_text = test_text;
			longer_text = test_text2;
			if (test_text2.length() - test_text.length() > 1)
				return false;
		}

		// ���� 0 ���� �� �� , ���� ��ü => �ϳ��� ���ڸ� Ʋ������

		if (test_text.length() == test_text2.length()) {
			while (i != test_text.length()) {

				if (test_text.charAt(i) != test_text2.charAt(i)) {
					if (!first_edit)
						first_edit = true;
					else
						return false;
				}

				i++;
			}

		}
		
		// ���� 1 ���� �� ��, ���� ���� �Ǵ� ���� ���� ����
		
		else {
			i = 0;
			while (i != shorter_text.length()) {

				if (longer_text.charAt(i) != shorter_text.charAt(i)) {
					if (!first_edit) {
						shorter_text = shorter_text.substring(0, i) + " " + shorter_text.substring(i);
						System.out.println("CHANGE shorter_text :"+ shorter_text);
						first_edit = true;
					}
					else
						return false;
				}
				i++;
			}
		}

		return true;

	}

	// -33 �ʿ� => index �� ����
	// ASCII 33 ~ 126

	public static void main(String[] args) {
		String test_text = "12345";
		String test_text2 = "2355";
		if (one_edit(test_text, test_text2))
			System.out.println("ture");
		else
			System.out.println("false");

	}

}
