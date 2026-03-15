import java.util.Scanner;

public class example10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入体重(kg)：");
        double weight = sc.nextDouble();

        System.out.print("请输入身高(m)：");
        double height = sc.nextDouble();

        Body.MassIndex(weight, height);

        sc.close();
    }
}