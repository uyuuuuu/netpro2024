public class NoHolidayException extends Exception {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("5月中の日付ではない値か、休日・土日ではない値です。");
    }
}
