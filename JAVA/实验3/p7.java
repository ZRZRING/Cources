public class p7 {
	public static void main(String[] args) {
        String words = "Words:";
        for (int i = 0; i < 6; i++) {
			char t = (char)(int)(Math.random() * 1000);
			while (t < 33 || t > 123) {
				t = (char)(int)(Math.random() * 1000);
			}
            words += t;
        }
        System.out.println("随机生成的字符串：" + words);
        System.out.println("拼接后字符串的长度：" + words.length());
        int uppercaseCount = 0;
        for (char c : words.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            }
        }
        System.out.println("大写英文字母的个数：" + uppercaseCount);
	}
}
