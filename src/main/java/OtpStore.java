public interface OtpStore {
    String create(OtpKey key);

    String getOtp(OtpKey key);
}
