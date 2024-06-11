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
        List<Lotto> manualLottos = getManualLottos(manualLottoCount);
        LottoGame lottoGame = new LottoGame(lottoPurchaseAmt, manualLottoCount);
        resultView.printLottoCount(lottoGame.getAutoCount(), manualLottoCount);

        List<Lotto> lottos = lottoGame.generateLotto(manualLottos);
        resultView.printLottos(lottos);

        List<Integer> winnerNumber = getWinnerNumber();
        int bonusNumber = getBonusWinnerNumber();

        extractWinners(lottos, winnerNumber, bonusNumber);
        resultView.printStatics(lottoPurchaseAmt);
    }

    private static void extractWinners(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            winningLotto.resultPrize(lotto);
        }
    }

    private Double getLottoPurchaseAmt() {
        return inputView.getLottoPurchaseAmt();
    }

    private int getManualLottoCount() {
        return inputView.getManualLottoCount();
    }

    private List<Lotto> getManualLottos(int manualLottoCount) {
        inputView.getManualLottoNumberPrint();
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            List<Integer> mannualLottoNumbers = getManualLottoNumbers();
            generateManualLotto(mannualLottoNumbers, manualLottos);
        }
        return manualLottos;
    }

    private void generateManualLotto(List<Integer> mannualLottoNumbers, List<Lotto> manualLottos) {
        Lotto manualLotto = new Lotto(new LottoNumber(mannualLottoNumbers));
        manualLottos.add(manualLotto);
    }

    private List<Integer> getManualLottoNumbers() {
        String manualNumbers = inputView.getManualLottoNumbers();
        List<String> numberStr = seperateComma(manualNumbers);
        return numberStr.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<Integer> getWinnerNumber() {
        String winnerNumber = inputView.getWinnerNumber();
        List<String> winners = seperateComma(winnerNumber);
        return winners.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }
    private static List<String> seperateComma(String input) {
        return Arrays.asList(input.trim().replaceAll("\\s", "").split(","));
    }
    private int getBonusWinnerNumber() {
        return inputView.getBonusWinnerNumber();
    }


}
