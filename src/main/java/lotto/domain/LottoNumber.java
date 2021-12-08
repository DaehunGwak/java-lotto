package lotto.domain;

import java.util.*;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private static final Map<Integer, LottoNumber> CACHED_LOTTO_NUMBER_MAP = new HashMap<>();
    private static final List<LottoNumber> CACHED_LOTTO_NUMBER_LIST = new ArrayList<>();

    static {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_END_NUMBER; i++) {
            LottoNumber lottoNumber = new LottoNumber(i);
            CACHED_LOTTO_NUMBER_MAP.put(i, lottoNumber);
            CACHED_LOTTO_NUMBER_LIST.add(lottoNumber);
        }
    }

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("number의 범위가 잘못되었습니다");
        }
        return CACHED_LOTTO_NUMBER_MAP.get(number);
    }

    public static List<LottoNumber> allLottoNumbers() {
        return Collections.unmodifiableList(CACHED_LOTTO_NUMBER_LIST);
    }

    public int lottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
