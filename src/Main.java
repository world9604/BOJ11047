import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * 이 문제는 위 거스름돈 문제의 업그레이드 버전이라고 할 수 있습니다.
         * 거스름 돈으로 줄 수 있는 화폐의 종류 또한 입력으로 받기 때문입니다.
         * 따라서 화폐의 종류를 담을 수 있는 배열을 하나 생성한 뒤에 배열에 담고,
         * 거슬러 줄 때는 하나씩 차례대로 처리하면 됩니다.
         * 다만 항상 화폐의 가치가 큰 것부터 나누어 주어야 하므로
         * 처리할 때는 순서를 거꾸로 하여 처리 해야 합니다.
         */

        /**
         * (문제)
         * 준규가 가지고 있는 동전은 총 N종류이고,
         * 각각의 동전을 매우 많이 가지고 있다.
         * 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.
         * 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
         */

        /**
         * (입력)
         * 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
         * 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다.
         * (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
         */

        /**
         * (출력)
         * 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
         */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int i = 0;
        int[] units = new int[N];

        for (int unit : units) {
            int input2 = sc.nextInt();
            units[i] = input2;
            i++;
        }

        new Greedy(units, K).caculate();
    }
}


class Greedy {
    private int total;
    private int[] units;
    private int minCnt;

    Greedy(int[] units, int total) {
        this.total = total;
        this.units = units;
        this.minCnt = 0;
    }

    public void caculate() {
        for (int i = units.length - 1; i >= 0; i--) {
            caculateUnit(units[i]);
        }
        System.out.printf("%d", minCnt);
    }

    private void caculateUnit(int unit) {
        minCnt += total / unit;
        total %= unit;
    }
}