package com.laoxiao.log.test;
import com.laoxiao.log.client.AnalyticsEngineSDK;

public class Test {
	public static void main(String[] args) {
		AnalyticsEngineSDK.onChargeSuccess("orderid123", "laoxiao123");
		AnalyticsEngineSDK.onChargeRefund("orderid456", "laoxiao456");
	}
}
