package ro.zynk.futureup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.zynk.futureup.controllers.requests.CoinExchangeRequest;
import ro.zynk.futureup.controllers.requests.CoinTransactionRequest;
import ro.zynk.futureup.controllers.responses.BaseResponse;
import ro.zynk.futureup.controllers.responses.ErrorResponse;
import ro.zynk.futureup.controllers.responses.WalletResponse;
import ro.zynk.futureup.exceptions.NotFoundException;
import ro.zynk.futureup.services.WalletService;


@RestController
@RequestMapping("/wallets")
public class WalletController {
    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping(value = "")
    public ResponseEntity<BaseResponse> saveWallet(@RequestBody WalletResponse walletResponse) {
        return new ResponseEntity<>(walletService.saveNewWallet(walletResponse), HttpStatus.OK);
    }


    @GetMapping(value = "")
    public ResponseEntity<BaseResponse> getWallets() {
        try {
            return new ResponseEntity<>(walletService.getWallets(), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BaseResponse> getWalletById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(walletService.getWallet(id), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/buy_coin")
    public ResponseEntity<BaseResponse> buyCoin(@RequestBody CoinTransactionRequest buyCoinRequest) {
        try {
            return new ResponseEntity<>(walletService.buyCoin(buyCoinRequest), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/exchange_coin")
    public ResponseEntity<BaseResponse> exchangeCoin(@RequestBody CoinExchangeRequest coinExchangeRequest) {
        try {
            return new ResponseEntity<>(walletService.exchangeCoin(coinExchangeRequest), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get_all_owned_coins/{walletId}")
    public ResponseEntity<BaseResponse> getAllOwnedCoinsFromWallet(@PathVariable("walletId") Long walletId) {
        try {
            return new ResponseEntity<>(walletService.getAllCoinsFromWallet(walletId), HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/get_sum_of_al_owned_coins")
    public ResponseEntity<BaseResponse> getSumOfWalletCoins(@RequestParam String walletId){
        try {
            return new ResponseEntity<>(walletService.getSumOfAllCoinsInWallet(Long.parseLong(walletId)),HttpStatus.OK);
        }
        catch (NotFoundException | NumberFormatException e) { //I added NumberFormatException just in case someone tries what I tried:) giving Not Long type
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get_all_transactions")
    public ResponseEntity<BaseResponse> getAllTrasactions(){
        try {
            return new ResponseEntity<>(walletService.getAllTransactions(),HttpStatus.OK);
        }
        catch (NotFoundException e) {
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/get_all_transactions_greater_than")
    public ResponseEntity<BaseResponse> getAllTrasactionsGreaterThan(@RequestParam String amountOfUsd)
    {
        try {
            return new ResponseEntity<>(walletService.getAllTransactionsGreaterThanPrice(Double.parseDouble(amountOfUsd)),HttpStatus.OK);
        }
        catch (NotFoundException | NumberFormatException e) { //I added NumberFormatException just in case someone tries what I tried:) giving Not Long type
            return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
