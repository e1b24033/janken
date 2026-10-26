package oit.is.z3420.kaizi.janken.model;

public class Janken {
  private String playerHand;
  private String cpuHand;
  private String result;

  public Janken(String playerHand) {
    this.playerHand = playerHand;
    this.cpuHand = "Gu";
    determineResult();
  }

  public void determineResult() {
    if (playerHand.equals(cpuHand)) {
      this.result = "あいこ";
    } else if ((playerHand.equals("Gu") && cpuHand.equals("Choki")) ||
        (playerHand.equals("Choki") && cpuHand.equals("Pa")) ||
        (playerHand.equals("Pa") && cpuHand.equals("Gu"))) {
      this.result = "あなたの勝ち";
    } else {
      this.result = "あなたの負け";
    }
  }

  public String getPlayerHand() {
    return playerHand;
  }

  public String getCpuHand() {
    return cpuHand;
  }

  public String getResult() {
    return result;
  }
}
