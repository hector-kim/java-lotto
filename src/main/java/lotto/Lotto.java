package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDup(numbers);
        this.numbers = numbers;
    }

    public static List<Integer> validateInput(List<Integer> lottoAnswer, String inputAnswer) throws IllegalArgumentException {
        String[] inputSplitAnswer = inputAnswer.split(",");
        for (String inputNumber : inputSplitAnswer) {
            int number = Integer.parseInt(inputNumber);
            if (number >= 0 && number <= 45) {
                lottoAnswer.add(number);
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 로또 번호는  ',' 로 구분된 1부터 45 사이의 숫자여야 합니다.");
        }
        return lottoAnswer;
    }

    private void validateCount(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개를 입력해주세요.");
        }
    }

    private void validateDup(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (numbers.contains(number) && numbers.indexOf(number) != numbers.lastIndexOf(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않는 숫자입니다.");
            }
        }
    }

    public void getLottoBonusNumber(String bonusNumber) throws IllegalArgumentException {
        validateBonusNumberInput(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDup(bonusNumber);
        numbers.add(Integer.parseInt(bonusNumber));
    }

    private void validateBonusNumberInput(String bonusNumber) throws IllegalArgumentException {
        for (int i = 0; i < bonusNumber.length(); i++) {
            if (bonusNumber.charAt(i) >= 48 && bonusNumber.charAt(i) <= 57) {
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 숫자로만 입력 해주세요");
        }
    }

    private void validateBonusNumberRange(String bonusNumber) throws IllegalArgumentException {
        int bonusNum = Integer.parseInt(bonusNumber);
        if (bonusNum>=0 && bonusNum<=45) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1부터 45사이의 숫자입니다.");
    }

    private void validateBonusNumberDup(String bonusNumber) throws IllegalArgumentException {
        if (numbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 로또번호와 중복되지 않아야합니다.");
        }
    }

    public List<Integer> printLottoNumber() {
        return numbers;
    }

}
