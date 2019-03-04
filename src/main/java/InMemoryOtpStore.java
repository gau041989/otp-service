import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InMemoryOtpStore implements OtpStore {

    private Map<OtpKey, String> store = new HashMap<>();
    private Random random = new Random();

    @Override
    public String create(OtpKey key) {
        return store.put(key, Integer.toString(random.nextInt()));
    }

    @Override
    public String getOtp(OtpKey key) {
        return store.get(key);
    }
}
