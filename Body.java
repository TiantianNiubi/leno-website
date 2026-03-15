public class Body {
    public static void MassIndex(double weight, double height) {
        double bmi = weight / (height * height);

        if (bmi < 18.5) {
            System.out.println("偏瘦");
        } else if (bmi < 25) {
            System.out.println("正常");
        } else if (bmi < 30) {
            System.out.println("超重");
        } else {
            System.out.println("肥胖");
        }
    }
}