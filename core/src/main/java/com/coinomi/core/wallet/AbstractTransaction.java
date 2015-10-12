package com.coinomi.core.wallet;

import com.coinomi.core.coins.CoinType;
import com.coinomi.core.coins.Value;
import com.coinomi.core.messages.TxMessage;
import com.coinomi.core.wallet.families.bitcoin.BitTransaction;
import com.coinomi.core.wallet.families.nxt.NxtTransaction;

import org.bitcoinj.core.Coin;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.TransactionConfidence;
import org.bitcoinj.core.TransactionInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by vbcs on 29/9/2015.
 */
public abstract class AbstractTransaction<T> {

    protected final T transaction;

    public AbstractTransaction(T transaction) {
        this.transaction = transaction;
    }

    public abstract TransactionConfidence getConfidence();

    public abstract String getHashAsString();

    public abstract Value getValue(AbstractWallet wallet);

    public abstract TxMessage getMessage();

    public Value getFee(AbstractWallet wallet) {
        return null;
    }

    public List<Map.Entry<AbstractAddress, Value>> getOutputs(AbstractWallet wallet) {
        return null;
    }

    public abstract byte[] getHash();

    public abstract boolean isCoinBase();

    public abstract boolean isCoinStake();

    public abstract boolean isMine(Map.Entry<AbstractAddress, Value> output);
}
