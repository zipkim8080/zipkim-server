package com.kb.zipkim.domain.prop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import static org.springframework.util.StringUtils.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NearByProp {

    Long id;

    String amount;

    String deposit;

    String recentAmount;

    String recentDeposit;

    Double depositRatio;

    Double recentDepositRatio;

    Double distance;
    public NearByProp(String amount, String deposit,String recentAmount, String recentDeposit,Double distance) {
        this.amount = amount;
        this.deposit = deposit;
        this.recentAmount = recentAmount;
        this.recentDeposit = recentDeposit;

        this.depositRatio = Double.parseDouble(deposit) / Double.parseDouble(amount);

        if (!hasText(recentAmount) || !hasText(recentDeposit) || Double.parseDouble(recentAmount) <= 0) {
            this.recentDepositRatio = 0.0;
        }
        this.distance = distance;
    }


}
