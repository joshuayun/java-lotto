package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();



    public void run() {
        double lottoPurchaseAmt = getLottoPurchaseAmt();
        LottoGame lottoGame = new LottoGame(lottoPurchaseAmt);
        resultView.printLottoCount(lottoGame.getCount());

        List<Lotto> lottos = lottoGame.generateLotto();
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

    private List<Integer> getWinnerNumber() {
        String winnerNumber = inputView.getWinnerNumber();
        List<String> winners = Arrays.asList(winnerNumber.trim().split(","));
        return winners.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    private int getBonusWinnerNumber() {
        return inputView.getBonusWinnerNumber();
    }
}
