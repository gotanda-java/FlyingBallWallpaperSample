package jp.co.techfun.flyingballwallpaper;

import android.graphics.Canvas;
import android.graphics.Color;

// 飛び回る玉のエフェクトを表示するクラス
public class FlyingBallEffect {
	// 飛び回る玉
	private Ball ball;
	private Ball ball2;

	// コンストラクタ
	public FlyingBallEffect() {
		// 玉オブジェクトを生成
		ball = new Ball();
		ball2 = new Ball();
	}

	// drawメソッド(壁紙描画処理)
	public void draw(Canvas canvas) {
		// 画面をクリア
		canvas.drawColor(Color.BLACK);
		canvas.save();

		ball.setBounds((int) ball.ballX, (int) ball.ballY, (int) ball.ballX + ball.ballDiameter,
				(int) ball.ballY + ball.ballDiameter);
		ball2.setBounds((int) ball2.ballX, (int) ball2.ballY, (int) ball2.ballX + ball2.ballDiameter,
				(int) ball2.ballY + ball2.ballDiameter);
		ball.draw(canvas);
		ball2.draw(canvas);

		canvas.restore();

		// 画面外へ玉が出た場合
		if (ball.width < ball.ballX || ball.height < ball.ballY || ball.ballX + ball.ballDiameter <= 0
				|| ball.ballY + ball.ballDiameter <= 0) {

			// 玉の表示位置を再設定
			ball.resetPosition();
		}
		
		if (ball2.width < ball2.ballX || ball2.height < ball2.ballY || ball2.ballX + ball2.ballDiameter <= 0
				|| ball2.ballY + ball2.ballDiameter <= 0){
			
			ball2.resetPosition();
		}
	}
}
