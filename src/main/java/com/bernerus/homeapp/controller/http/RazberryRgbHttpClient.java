package com.bernerus.homeapp.controller.http;

import com.bernerus.homeapp.config.HttpClientConfig;
import com.bernerus.homeapp.model.RGBColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;

/**
 * Created by andreas on 21/02/17.
 */
public class RazberryRgbHttpClient extends RazberryHttpClient {
  private static final Logger LOG = LoggerFactory.getLogger(RazberryRgbHttpClient.class);

  public RazberryRgbHttpClient(HttpClientConfig clientConfig, String deviceId) {
    super(clientConfig, deviceId);
  }

  public void setBedBoxColor(RGBColor color) {
    String red = String.valueOf(color.getRed());
    String green = String.valueOf(color.getGreen());
    String blue = String.valueOf(color.getBlue());
    String url = "/ZAutomation/api/v1/devices/" + deviceId + "/command/exact?red=" + red + "&green=" + green + "&blue=" + blue;

    LOG.info(url);

    HttpEntity<String> response = get(url, String.class);

    try {
      LOG.info(response.getBody());
    } catch (Exception e) {
      LOG.error("Kass", e);
    }
  }


}