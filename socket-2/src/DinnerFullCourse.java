
public class DinnerFullCourse {
    private Dish[] list = new Dish[5];// [0]-[4]の計5個

    DinnerFullCourse() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new Dish();
        }
        list[0].setName("ジェノベーゼ");
        list[0].setValune(980);
        list[1].setName("ペペロンチーノ");
        list[1].setValune(880);
        list[2].setName("マルゲリータ");
        list[2].setValune(1020);
        list[3].setName("4種のチーズピザ");
        list[3].setValune(1080);
        list[4].setName("ティラミス");
        list[4].setValune(690);
    }

    public static void main(String[] args) {

        DinnerFullCourse fullcourse = new DinnerFullCourse();
        fullcourse.eatAll();
    }

    public void eatAll() {
        System.out.println("～料理一覧～");
        for (Dish d : list) {
            System.out.println(d.getName() + "(" + d.getValune() + "円)");
        }
    }
}