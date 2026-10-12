package oit.is.z3420.kaizi.janken.model;

public class Janken {
  private String playerHand;
  private String cpuHand;
  private String result;

  public Janken(String playerHand) {
    this.playerHand = playerHand;
    this.cpuHand = "グー";
    determineResult();
  }

  public void determineResult() {
    if (playerHand.equals(cpuHand)) {
      this.result = "あいこ";
    } else if ((playerHand.equals("グー") && cpuHand.equals("チョキ")) ||
        (playerHand.equals("チョキ") && cpuHand.equals("パー")) ||
        (playerHand.equals("パー") && cpuHand.equals("グー"))) {
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
