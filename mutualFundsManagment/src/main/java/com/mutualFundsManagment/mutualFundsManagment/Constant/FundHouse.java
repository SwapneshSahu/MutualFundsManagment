package com.mutualFundsManagment.mutualFundsManagment.Constant;

public enum FundHouse {
    Nippon_India_Mutual_Fund("Nippon India Mutual Fund"),
    Canara_Robeco_Mutual_Fund("Canara Robeco Mutual Fund"),
    DSP_Mutual_Fund("DSP Mutual Fund"),
    Tata_Mutual_Fund("Tata Mutual Fund"),
    Kotak_Mahindra_Mutual_Fund("Kotak Mahindra Mutual Fund"),
    SBI_Mutual_Fund("SBI Mutual Fund"),
    ICICI_Prudential_Mutual_Fund("ICICI Prudential Mutual Fund"),
    Axis_Mutual_Fund("Axis Mutual Fund"),
    Edelweiss_Mutual_Fund("Edelweiss Mutual Fund"),
    HDFC_Mutual_Fund("HDFC Mutual Fund"),
    Mirae_Asset_Mutual_Fund("Mirae Asset Mutual Fund"),
    PPFAS_Mutual_Fund("PPFAS Mutual Fund"),
    quant_Mutual_Fund("quant Mutual Fund"),
    Quantum_Mutual_Fund("Quantum Mutual Fund");


    private final String label;

    FundHouse(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
