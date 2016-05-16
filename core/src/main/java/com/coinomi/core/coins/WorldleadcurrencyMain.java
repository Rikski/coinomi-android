package com.coinomi.core.coins;

import com.coinomi.core.coins.families.BitFamily;
import com.coinomi.core.coins.families.WlcFamily;

/**
 * @author John L. Jegutanis
 */
public class WorldleadcurrencyMain extends WlcFamily {
    private WorldleadcurrencyMain() {
        id = "worldleadcurrency.main";

        addressHeader = 0;
        p2shHeader = 5;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        spendableCoinbaseDepth = 100;
        dumpedPrivateKeyHeader = 128;

        name = "Worldleadcurrency";
        symbol = "WLC";
        uriScheme = "worldleadcurrency";
        bip44Index = 0;
        unitExponent = 8;
        feeValue = value(12000);
        minNonDust = value(5460);
        softDustLimit = value(1000000); // 0.01 WLC
        softDustPolicy = SoftDustPolicy.AT_LEAST_BASE_FEE_IF_SOFT_DUST_TXO_PRESENT;
        signedMessageHeader = toBytes("Bitcoin Signed Message:\n");
    }

    private static WorldleadcurrencyMain instance = new WorldleadcurrencyMain();
    public static synchronized CoinType get() {
        return instance;
    }
}
