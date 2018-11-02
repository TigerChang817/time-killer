import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GuessNumber {

  public static void main(String[] args) {
    String repeat = "";
    while (repeat.equals("") || repeat.equals("y")){
      int num1 = 0;
      Scanner scanner = new Scanner(System.in);
      System.out.println("請輸入數字決定幾位數(1~10)：");
      try {
        num1 = scanner.nextInt();
      } catch (Exception e) {
        System.out.println("請輸入數字好嗎?? zzz");
      }
      while (num1 == 0 || num1 > 10) {
        System.out.println("請輸入數字1~10");
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("請輸入數字決定幾位數(1~10)：");
        try {
          num1 = scanner1.nextInt();
        } catch (Exception e) {
          System.out.println("請輸入數字好嗎?? zzz");
        }
      }

      System.out.println("你選擇的為猜數字的位數為" + num1 + "位");
      List<String> strings = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "0");
      Collections.shuffle(strings);
      String ans = "";
      for (int i = 0; i < num1; i++) {
        ans += strings.get(i);
      }
//      System.out.println(ans);
      System.out.println("該開始猜了吧!!");
      long start = System.currentTimeMillis();

      Scanner scanner2 = new Scanner(System.in);
      String string = scanner2.nextLine();
      while (!ans.equals(string)) {
        try {
          Integer.parseInt(string);
          // 避免重複數字
          if (string.length() == num1) {
            if (getNotEqualNum(string)) {
              // 設定幾A幾B
              System.out.println(getXAXB(ans, string));
            } else {
              System.out.println("請不要輸入相同數字好嗎??");
            }
          } else {
            System.out.println("請輸入" + num1 + "個不重複數字好嗎??");
          }
          Scanner scanner4 = new Scanner(System.in);
          string = scanner4.nextLine();
        } catch (Exception e) {
          System.out.println("請輸入數字好嗎?? zzz");
          Scanner scanner3 = new Scanner(System.in);
          string = scanner3.nextLine();
        }
      }
      System.out.println("恭喜你答對了!! ^_^");
      long end = System.currentTimeMillis();
      long costtime = end - start;
      System.out.println("費時"+ (double)costtime/1000D +"秒");
      System.out.println("再來一場? [y/n]");
      Scanner scanner4 = new Scanner(System.in);
      repeat = scanner4.nextLine();
    }
  }

  public static boolean getNotEqualNum(String string) {
    char[] chars = string.toCharArray();
    for (char ch : chars) {
      if (string.indexOf(ch) != string.lastIndexOf(ch)) {
        return false;
      }
    }
    return true;
  }

  public static String getXAXB(String ans, String guess) {
    int a = 0;
    int b = 0;
    char[] ansC = ans.toCharArray();
    char[] guessC = guess.toCharArray();
    for (int i = 0; i < ans.length(); i++) {
      if (ansC[i] == guessC[i]) {
        a++;
      }
      if (ans.indexOf(guessC[i]) != -1) {
        b++;
      }
    }
    b = b - a;
    return a + "A" + b + "B";
  }
}
