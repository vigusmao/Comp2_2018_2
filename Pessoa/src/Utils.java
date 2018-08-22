import java.util.Calendar;

public class Utils {

    public static int getAnoCorrente() {
        Calendar hoje = Calendar.getInstance();
        int anoCorrente = hoje.get(Calendar.YEAR);
        return anoCorrente;
    }
}
