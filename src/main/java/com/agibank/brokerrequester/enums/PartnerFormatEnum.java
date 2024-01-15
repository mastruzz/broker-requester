package com.agibank.brokerrequester.enums;

public enum PartnerFormatEnum {

    TECBAN,
    DOCK;

    public static PartnerFormatEnum verifyPartnerIsTecban(boolean tecbanToggle) {
        return tecbanToggle ? TECBAN : DOCK;
    }
}
