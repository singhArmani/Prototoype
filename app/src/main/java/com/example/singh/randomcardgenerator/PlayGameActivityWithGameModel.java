package com.example.singh.randomcardgenerator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlayGameActivityWithGameModel extends AppCompatActivity implements  AdapterView.OnItemClickListener {

    //private PlayingCardDeck deck;
    private int flipCount=0;
    private myCounter countDownTimer;
    private  long startTime = 20000;
    private final long interval = 1000;
    TextView _myGameTimer = null;
    private TextView flipLable;
    private CardMatchingGame game;
    private List<Button> cardButtons;
    private TextView _gameInfo;

    //setting up the list view
    ListView l;
    String[] navigationOptions={"New Game","Help","Exit"};

    //Drawer
    private  DrawerLayout drawer;

    //Saving HighScores
    public static final String HIGH_SCORE = "HighScores";
    private SharedPreferences prefs;
    TextView highScore;

    public void setCardButton(List<Button> cardButton) {
        this.cardButtons = cardButton;
        this.updateUI();
    }


    public void updateUI(){
       //looping through all the cards and upate them individually
       for(Button cardButton:cardButtons){
           //get that single card by asking model to give you card at index
           Card card = this.getGame().cardAtIndex(cardButtons.indexOf(cardButton));//mapping model with UI

           //now we have the card from the model linked with UI, now we can set it's conten4t
           PlayingCard pc = (PlayingCard)card;
           if(card.getFaceUp()) {
               cardButton.setText(pc.getRank() + pc.getSuit());
           }
           else
           {
               cardButton.setText("card");
           }
           cardButton.setEnabled(!card.getUnplayable());



           //setting the opacity of the card
           cardButton.setAlpha((card.getUnplayable())?0.3f:1.0f);

           //updating the score here
           ((TextView)findViewById(R.id.score)).setText("Score: " + this.getGame().getScore());
       }
   }

    //lazy instantiation
    public CardMatchingGame getGame() {
        if(game==null){

            game = new CardMatchingGame(cardButtons.size(),new PlayingCardDeck());
        }
        return game;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

       //linking the card button of layout with java code
        List<Button>myRandomButton = new ArrayList<>(20);
        myRandomButton.add((Button) findViewById(R.id.card1));
        myRandomButton.add((Button) findViewById(R.id.card2));
        myRandomButton.add((Button) findViewById(R.id.button));
        myRandomButton.add((Button) findViewById(R.id.button2));
        myRandomButton.add((Button) findViewById(R.id.button3));
        myRandomButton.add((Button) findViewById(R.id.button4));
        myRandomButton.add((Button) findViewById(R.id.button5));
        myRandomButton.add((Button) findViewById(R.id.button6));
        myRandomButton.add((Button) findViewById(R.id.button7));
        myRandomButton.add((Button) findViewById(R.id.button8));
        myRandomButton.add((Button) findViewById(R.id.button9));
        myRandomButton.add((Button) findViewById(R.id.button10));
        myRandomButton.add((Button) findViewById(R.id.button11));
        myRandomButton.add((Button) findViewById(R.id.button12));
        myRandomButton.add((Button) findViewById(R.id.button13));
        myRandomButton.add((Button) findViewById(R.id.button14));
        myRandomButton.add((Button) findViewById(R.id.button15));
        myRandomButton.add((Button) findViewById(R.id.button16));
        myRandomButton.add((Button) findViewById(R.id.button17));
        myRandomButton.add((Button) findViewById(R.id.button18));

        //calling the setter method for cardButtons Array
        setCardButton(myRandomButton);

        //linking the flipLable TextView with java code
        flipLable = (TextView) findViewById(R.id.flip_count);

        //setting up the navigation_drawer
        l = (ListView) findViewById(R.id.navList);

        //creating ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,navigationOptions);

        //setting up the adapter
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);

        //creating instance of myCounter.
        countDownTimer = new myCounter(startTime,interval);
       // countDownTimer.currentActivity = this;

        //setting up the text value
       _myGameTimer= (TextView)findViewById(R.id.myGameTimer);
        _myGameTimer.setText("Timer: " + String.valueOf(startTime / 1000)+"s");

        //setting up the gameInfo
        _gameInfo = (TextView)findViewById(R.id.gameInfo);//getting the gameInfo textview

        //setting up the drawer
        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);

        //setting up the prefs
        prefs = getSharedPreferences(HIGH_SCORE,MODE_PRIVATE);

        highScore= ((TextView)findViewById(R.id.highScore));//hooking up our textView
        highScore.setText("HighScore: " + String.valueOf(prefs.getInt("HighScore", 0)));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new_game) {
            PlayGameActivityWithGameModel.this.NewGame();//start a new game
            return true;
        }

        if (id == R.id.action_help) {
            //start the help activity here
            Intent helpIntent = new Intent(this,helpActivity.class);
            startActivity(helpIntent);
            return true;
        }

        if(id==R.id.action_reset_highScore)
        {
                    SharedPreferences.Editor reset = prefs.edit();
                    reset.putInt("HighScore",0);
                    reset.commit();
                    highScore.setText("HighScore: "+prefs.getInt("HighScore",0));//setting the highScore
        }

        return super.onOptionsItemSelected(item);
    }

    //flipping card here
    public void onFlip(View view)
    {
        //starting the timer
        if(!countDownTimer.is_timeHasStarted()) {
            countDownTimer.start();//starting the timer here
            countDownTimer.set_timeHasStarted(true);
        }


        //incrementing the flipcount
        flipCount++;
         Button _button = (Button)findViewById(view.getId());

        flipLable.setText("Flips:" + flipCount);

        //game score before flipping
        int _initalScore = this.getGame().getScore();

        //lets ask our model to do the flipping job
        this.getGame().flipCardAtIndex(this.cardButtons.indexOf(_button));

        int _scoreAfterTapping = this.getGame().getScore();//score after flipping

        int _scoreDifference = _scoreAfterTapping-_initalScore;//score difference


        this.Status(_scoreDifference,_button);//updating status evertime flipping is done

        this.updateUI();//updating the UI
    }

   public void Status(int scoreDiffernce, Button button)
   {


       PlayingCard pc= (PlayingCard) this.getGame().cardAtIndex(this.cardButtons.indexOf(button));

       switch(scoreDiffernce){
           case 3:

               _gameInfo.setText("It was a Suit match of " + pc.getSuit());//getting the first part of string which is suit

               break;
           case 15:

               _gameInfo.setText("It was a Rank match of " + pc.getRank());//getting the second part of string which is rank

               break;
           case -3:
               _gameInfo.setText("It was a Mis-Match!!!");
               break;
           case -1:
               _gameInfo.setText("Flipping Cost of -1");
               break;
       }
   }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      if(position ==0){
          //start a new game
           PlayGameActivityWithGameModel.this.NewGame();
          drawer.closeDrawers();//closing the drawer
      }
        else{
          //exit the activity
      }
    }


    //myCounter class
    public class myCounter extends CountDownTimer {

        private boolean _timeHasStarted = false;
        private boolean _gameOver = false;

        // public Activity currentActivity;

        public boolean is_timeHasStarted() {
            return _timeHasStarted;
        }

        public void set_timeHasStarted(boolean _timeHasStarted) {
            this._timeHasStarted = _timeHasStarted;
        }


        public myCounter(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            _myGameTimer.setText("Timer: " + millisUntilFinished / 1000+"s");
            startTime = millisUntilFinished;
        }

        @Override
        public void onFinish() {
            //game over dialog popup message with the score made
            _myGameTimer.setText("Game Over");
            _gameOver= true;//setting the gameOver true;

            //why final ???
            final int score =CardMatchingGame.currentCardMatchingGame.getScore();
            final SharedPreferences.Editor editor = prefs.edit();
           // editor.putInt("highScore",score);
           // editor.putInt("currentScore",score);
           // editor.commit();

            AlertDialog.Builder myalert = new AlertDialog.Builder(PlayGameActivityWithGameModel.this);
            myalert.setTitle("Game Over");
            if(score>prefs.getInt("HighScore",0))
            {
                myalert.setMessage("Great!!That's high Score of "+score);

                myalert.setPositiveButton("Save High Score", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editor.putInt("HighScore", score);
                        editor.commit();//doing commit here
                        PlayGameActivityWithGameModel.this.NewGame();//starting new game
                    }
                });
                myalert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editor.putInt("HighScore",0);
                        editor.commit();
                        PlayGameActivityWithGameModel.this.NewGame();//starting new game
                    }
                });
            }
            else {
                myalert.setMessage("Your Score: " + score);
                myalert.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PlayGameActivityWithGameModel.this.NewGame();//starting new game
                    }
                });

                myalert.setNegativeButton("Back to Main", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Main Screen clicked", Toast.LENGTH_SHORT).show();
                        //return to main activity
                        Intent mainIntentObject = new Intent(PlayGameActivityWithGameModel.this, MainActivity.class);
                        startActivity(mainIntentObject);
                    }
                });
            }
            myalert.setCancelable(false);//so to make background window unclickable
            myalert.create();
            myalert.show();


        }
    }
    //new game
    public void NewGame()
    {
        //start a new game
        this.game = new CardMatchingGame(cardButtons.size(),new PlayingCardDeck());

        this.flipCount=0;

        //updating the UI again
        this.updateUI();


        //resetting the timer
         countDownTimer.cancel();
         startTime=20000;

        //creating instance of myCounter.
        countDownTimer = new myCounter(startTime,interval);
        countDownTimer.set_timeHasStarted(false);
        _myGameTimer.setText("Timer: " + String.valueOf(startTime / 1000) + "s");

        this._gameInfo.setText("Tap Card To Play");
        this.flipLable.setText("Flips:" + flipCount);

        highScore.setText("HighScore: "+prefs.getInt("HighScore",0));

    }

    //on resume

   @Override
  protected void onResume() {
        super.onResume();
        if(countDownTimer.is_timeHasStarted())
        {
            countDownTimer= new myCounter(startTime,interval);
            countDownTimer.start();
            _myGameTimer.setText("Timer: " + String.valueOf(startTime / 1000) + "s");//setting the timevalue again
            countDownTimer.set_timeHasStarted(true);

        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        countDownTimer.cancel();//pausing the timer when acitivity is in background.
    }
}


