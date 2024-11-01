import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many data you will put?");
        int howManyData = scan.nextInt();
        Double[] data = new Double[howManyData];

        for (int i = 0; i < howManyData; i++) {
            System.out.println("Insert data NO." + i);
            data[i] = scan.nextDouble();
        }
        System.out.println("ROL of raw data(crescent) bellow");
        Arrays.sort(data);

        for (Double x : data) {
            System.out.println(x);
        }

        Double[] variableNotate = XiTable(data);

        Double[] freq = new Double[variableNotate.length];

        int indexOfFreq = 0;
        for (double x : variableNotate) {
            freq[indexOfFreq] = countOfVariable(x, data);
            indexOfFreq++;
        }

        System.out.println("fi Table bellow");
        for (Double x : freq) {
            System.out.println(x);
        }

        scan.close();
    }

    public static Double countOfVariable(Double x, Double[] data) {
        double counter = 0.0;
        for (Double y : data) {
            if (y.equals(x)) {
                counter++;
            }
        }
        return counter;
    }

    public static Double[] XiTable(Double[] data) {

        Double dataNO = data[0];
        Double[] variableNotate = new Double[data.length];

        variableNotate[0] = dataNO;
        int index = 1;

        for (Double x : data) {
            if (x.equals(dataNO)) {
                continue;
            } else {
                variableNotate[index] = x;
                dataNO = x;
            }
            index++;
        }

        double counter = 0;
        for (Double x : variableNotate) {
            if (x == null)
                counter++;
        }

        Double VNDLength = (counter - data.length) * -1;
        int vndLength = (int) Math.round(VNDLength);
        Double[] variableNotateDefinitive = new Double[vndLength];

        for (int i = 0; i < variableNotateDefinitive.length; i++) {
            variableNotateDefinitive[i] = variableNotate[i];
        }

        System.out.println("Xi table bellow");
        for (Double x : variableNotateDefinitive) {
            System.out.println(x);
        }
        return variableNotateDefinitive;
    }

}
