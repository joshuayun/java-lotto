package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();



    public void run() {
        double lottoPurchaseAmt = getLottoPurchaseAmt();
        int manualLottoCount = getManualLottoCount();
        List<Lotto> manualLottos = getManualLottoNumber(manualLottoCount);
        LottoGame lottoGame = new LottoGame(lottoPurchaseAmt, manualLottoCount);
        resultView.printLottoCount(lottoGame.getAutoCount(), manualLottoCount);

        List<Lotto> lottos = lottoGame.generateLotto(manualLottos);
        resultView.printLottos(lottos);

        List<Integer> winnerNumber = getWinnerNumber();
        int bonusNumber = getBonusWinnerNumber();

        WinnerLotto winnerLotto = new WinnerLotto(winnerNumber, bonusNumber);
        extractWinners(lottos, winnerLotto);
        resultView.printStatics(lottoPurchaseAmt);
    }



    private static void extractWinners(List<Lotto> lottos, WinnerLotto winnerLotto) {
        for (Lotto lotto : lottos) {
            Winning winning = new Winning(winnerLotto, lotto);
            winning.compareNumbers();
        }
    }

    private Double getLottoPurchaseAmt() {
        return inputView.getLottoPurchaseAmt();
    }

    private int getManualLottoCount() {
        return inputView.getManualLottoCount();
    }

    private List<Lotto> getManualLottoNumber(int manualLottoCount) {
        inputView.getManualLottoNumberPrint();
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String manualNumbers = inputView.getManualLottoNumber();
            List<String> numberStr = Arrays.asList(manualNumbers.trim().replaceAll("\\s", "").split(","));
            List<Integer> numbers = numberStr.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            Lotto manualLotto = new Lotto(new LottoNumber(numbers));
            manualLottos.add(manualLotto);
        }
        return manualLottos;
    }

    private List<Integer> getWinnerNumber() {
        String winnerNumber = inputView.getWinnerNumber();
        List<String> winners = Arrays.asList(winnerNumber.trim().replaceAll("\\s", "").split(","));
        return winners.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    private int getBonusWinnerNumber() {
        return inputView.getBonusWinnerNumber();
    }
}
