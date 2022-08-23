package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Anim animation;
	private float speed = 200.0f;


	@Override
	public void create () {
		batch = new SpriteBatch();
		animation = new Anim("favpng_sprite-animation-2d-computer-graphics-video-game.png",5, 2,Animation.PlayMode.LOOP  );
	}


	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		animation.setTime(Gdx.graphics.getDeltaTime());

		float x = 0;
		float t = 0;
		float t1 = 0;
		float t2 = 0;
		t = animation.getTime();

		if (!animation.getFrame().isFlipX()){
			x = t*this.speed;
			if (x >= Gdx.graphics.getWidth()-animation.getFrame().getRegionWidth())
				animation.getFrame().flip(true, false);
		}

		if (animation.getFrame().isFlipX()){
			x -= t*this.speed;
		}

		batch.begin();
		batch.draw(animation.getFrame(), x, 0);
		batch.end();
	}

	
	@Override
	public void dispose () {
		batch.dispose();
		animation.dispose();
	}
}
