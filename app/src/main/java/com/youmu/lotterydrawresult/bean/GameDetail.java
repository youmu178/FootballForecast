package com.youmu.lotterydrawresult.bean;

import java.util.ArrayList;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcel;


public class GameDetail implements Parcelable{

    private static final String FIELD_OU_ODDS = "ou_odds";
    private static final String FIELD_LOCATION = "location";
    private static final String FIELD_AWAY_UNIFIED_COMMENTS = "away_unified_comments";
    private static final String FIELD_LEAGUE_ID = "league_id";
    private static final String FIELD_HOME_WIN_US = "home_win_us";
    private static final String FIELD_HOME_UNIFIED_COMMENTS = "home_unified_comments";
    private static final String FIELD_ID = "id";
    private static final String FIELD_LEAGUE_NAME = "league_name";
    private static final String FIELD_HOME_SCORED_AT_VENUE = "home_scored_at_venue";
    private static final String FIELD_LAST_MATCHES = "last_matches";
    private static final String FIELD_AWAY_GOALS_CHART = "away_goals_chart";
    private static final String FIELD_AWAY_TEAM_ID = "away_team_id";
    private static final String FIELD_HOME_GOALS_CHART = "home_goals_chart";
    private static final String FIELD_PICKS = "picks";
    private static final String FIELD_SCORE_GOALS_CHART = "score_goals_chart";
    private static final String FIELD_HOME_GOALS = "home_goals";
    private static final String FIELD_CONSENSUS = "consensus";
    private static final String FIELD_SEASON = "season";
    private static final String FIELD_DRAW = "draw";
    private static final String FIELD_AWAY_GOALS = "away_goals";
    private static final String FIELD_AWAY_MLINE_ACCURACY = "away_mline_accuracy";
    private static final String FIELD_BOTH_TEAMS_TO_SCORE = "both_teams_to_score";
    private static final String FIELD_DATE = "date";
    private static final String FIELD_AWAY_TEAM_NAME = "away_team_name";
    private static final String FIELD_AWAY_WINS_AT_VENUE = "away_wins_at_venue";
    private static final String FIELD_HISTORICAL_RECORDS_DATA = "historical_records_data";
    private static final String FIELD_HOME_TEAM_NAME = "home_team_name";
    private static final String FIELD_MLINE_ODDS = "mline_odds";
    private static final String FIELD_HOT_GAME = "hotGame";
    private static final String FIELD_ODDS_TABLE = "odds_table";
    private static final String FIELD_SPREAD_PREDICTIONS = "spread_predictions";
    private static final String FIELD_HOME_STAT_COMMENTS = "home_stat_comments";
    private static final String FIELD_AWAY_RANKING = "away_ranking";
    private static final String FIELD_HOME_WIN = "home_win";
    private static final String FIELD_LINE_MOVES = "line_moves";
    private static final String FIELD_AWAY_INDEX = "away_index";
    private static final String FIELD_HOME_RANKING = "home_ranking";
    private static final String FIELD_TOTAL_GOALS_PREDICTION = "total_goals_prediction";
    private static final String FIELD_AWAY_SCORED_AT_VENUE = "away_scored_at_venue";
    private static final String FIELD_HOME_MLINE_ACCURACY = "home_mline_accuracy";
    private static final String FIELD_TOUR = "tour";
    private static final String FIELD_JC_GAME = "jcGame";
    private static final String FIELD_HOME_TEAM_ID = "home_team_id";
    private static final String FIELD_DRAW_US = "draw_us";
    private static final String FIELD_TEAMS_LEAGUE_POSITIONS = "teams_league_positions";
    private static final String FIELD_RESULTS = "results";
    private static final String FIELD_SPREAD_ODDS = "spread_odds";
    private static final String FIELD_HOME_AVG = "home_avg";
    private static final String FIELD_AWAY_WIN_US = "away_win_us";
    private static final String FIELD_AWAY_WIN = "away_win";
    private static final String FIELD_CURRENT_FORM = "current_form";
    private static final String FIELD_AWAY_STAT_COMMENTS = "away_stat_comments";
    private static final String FIELD_HOME_INDEX = "home_index";
    private static final String FIELD_HOME_WINS_AT_VENUE = "home_wins_at_venue";
    private static final String FIELD_PROBABILITY_TO_WIN = "probability_to_win";
    private static final String FIELD_WIN_TO_NIL = "win_to_nil";
    private static final String FIELD_AWAY_AVG = "away_avg";

    private static final String FIELD_STATE = "state";
    private static final String FIELD_MESSAGE = "message";
    private static final String FIELD_ERROR = "error";

    @SerializedName(FIELD_STATE)
    private boolean mState;
    @SerializedName(FIELD_MESSAGE)
    private String mMessage;
    @SerializedName(FIELD_ERROR)
    private String mError;
    @SerializedName(FIELD_OU_ODDS)
    private List<OuOdd> mOuOdds;
    @SerializedName(FIELD_LOCATION)
    private String mLocation;
    @SerializedName(FIELD_AWAY_UNIFIED_COMMENTS)
    private List<String> mAwayUnifiedComments;
    @SerializedName(FIELD_LEAGUE_ID)
    private int mLeagueId;
    @SerializedName(FIELD_HOME_WIN_US)
    private int mHomeWinUs;
    @SerializedName(FIELD_HOME_UNIFIED_COMMENTS)
    private List<String> mHomeUnifiedComments;
    @SerializedName(FIELD_ID)
    private long mId;
    @SerializedName(FIELD_LEAGUE_NAME)
    private String mLeagueName;
    @SerializedName(FIELD_HOME_SCORED_AT_VENUE)
    private int mHomeScoredAtVenue;
    @SerializedName(FIELD_LAST_MATCHES)
    private List<LastMatch> mLastMatches;
    @SerializedName(FIELD_AWAY_GOALS_CHART)
    private List<AwayGoalsChart> mAwayGoalsCharts;
    @SerializedName(FIELD_AWAY_TEAM_ID)
    private int mAwayTeamId;
    @SerializedName(FIELD_HOME_GOALS_CHART)
    private List<HomeGoalsChart> mHomeGoalsCharts;
    @SerializedName(FIELD_PICKS)
    private List<Pick> mPicks;
    @SerializedName(FIELD_SCORE_GOALS_CHART)
    private List<ScoreGoalsChart> mScoreGoalsCharts;
    @SerializedName(FIELD_HOME_GOALS)
    private int mHomeGoal;
    @SerializedName(FIELD_CONSENSUS)
    private List<Consensus> mConsensus;
    @SerializedName(FIELD_SEASON)
    private int mSeason;
    @SerializedName(FIELD_DRAW)
    private int mDraw;
    @SerializedName(FIELD_AWAY_GOALS)
    private int mAwayGoal;
    @SerializedName(FIELD_AWAY_MLINE_ACCURACY)
    private int mAwayMlineAccuracy;
    @SerializedName(FIELD_BOTH_TEAMS_TO_SCORE)
    private List<BothTeamsToScore> mBothTeamsToScores;
    @SerializedName(FIELD_DATE)
    private Long mDate;
    @SerializedName(FIELD_AWAY_TEAM_NAME)
    private String mAwayTeamName;
    @SerializedName(FIELD_AWAY_WINS_AT_VENUE)
    private int mAwayWinsAtVenue;
    @SerializedName(FIELD_HISTORICAL_RECORDS_DATA)
    private HistoricalRecordsDatum mHistoricalRecordsDatum;
    @SerializedName(FIELD_HOME_TEAM_NAME)
    private String mHomeTeamName;
    @SerializedName(FIELD_MLINE_ODDS)
    private List<MlineOdd> mMlineOdds;
    @SerializedName(FIELD_HOT_GAME)
    private int mHotGame;
    @SerializedName(FIELD_ODDS_TABLE)
    private List<OddsTable> mOddsTables;
    @SerializedName(FIELD_SPREAD_PREDICTIONS)
    private List<SpreadPrediction> mSpreadPredictions;
    @SerializedName(FIELD_HOME_STAT_COMMENTS)
    private List<String> mHomeStatComments;
    @SerializedName(FIELD_AWAY_RANKING)
    private List<AwayRanking> mAwayRankings;
    @SerializedName(FIELD_HOME_WIN)
    private int mHomeWin;
    @SerializedName(FIELD_LINE_MOVES)
    private List<LineMove> mLineMoves;
    @SerializedName(FIELD_AWAY_INDEX)
    private double mAwayIndex;
    @SerializedName(FIELD_HOME_RANKING)
    private List<HomeRanking> mHomeRankings;
    @SerializedName(FIELD_TOTAL_GOALS_PREDICTION)
    private List<TotalGoalsPrediction> mTotalGoalsPredictions;
    @SerializedName(FIELD_AWAY_SCORED_AT_VENUE)
    private int mAwayScoredAtVenue;
    @SerializedName(FIELD_HOME_MLINE_ACCURACY)
    private int mHomeMlineAccuracy;
    @SerializedName(FIELD_TOUR)
    private int mTour;
    @SerializedName(FIELD_JC_GAME)
    private int mJcGame;
    @SerializedName(FIELD_HOME_TEAM_ID)
    private int mHomeTeamId;
    @SerializedName(FIELD_DRAW_US)
    private int mDrawUs;
    @SerializedName(FIELD_TEAMS_LEAGUE_POSITIONS)
    private List<TeamsLeaguePosition> mTeamsLeaguePositions;
    @SerializedName(FIELD_RESULTS)
    private Result mResult;
    @SerializedName(FIELD_SPREAD_ODDS)
    private List<SpreadOdd> mSpreadOdds;
    @SerializedName(FIELD_HOME_AVG)
    private List<HomeAvg> mHomeAvgs;
    @SerializedName(FIELD_AWAY_WIN_US)
    private int mAwayWinUs;
    @SerializedName(FIELD_AWAY_WIN)
    private int mAwayWin;
    @SerializedName(FIELD_CURRENT_FORM)
    private CurrentForm mCurrentForm;
    @SerializedName(FIELD_AWAY_STAT_COMMENTS)
    private List<String> mAwayStatComments;
    @SerializedName(FIELD_HOME_INDEX)
    private double mHomeIndex;
    @SerializedName(FIELD_HOME_WINS_AT_VENUE)
    private int mHomeWinsAtVenue;
    @SerializedName(FIELD_PROBABILITY_TO_WIN)
    private List<ProbabilityToWin> mProbabilityToWins;
    @SerializedName(FIELD_WIN_TO_NIL)
    private List<WinToNil> mWinToNils;
    @SerializedName(FIELD_AWAY_AVG)
    private List<AwayAvg> mAwayAvgs;


    public GameDetail(){

    }
    public void setState(boolean state) {
        mState = state;
    }

    public boolean isState() {
        return mState;
    }
    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getmError() {
        return mError;
    }

    public void setmError(String mError) {
        this.mError = mError;
    }

    public void setOuOdds(List<OuOdd> ouOdds) {
        mOuOdds = ouOdds;
    }

    public List<OuOdd> getOuOdds() {
        return mOuOdds;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setAwayUnifiedComments(List<String> awayUnifiedComments) {
        mAwayUnifiedComments = awayUnifiedComments;
    }

    public List<String> getAwayUnifiedComments() {
        return mAwayUnifiedComments;
    }

    public void setLeagueId(int leagueId) {
        mLeagueId = leagueId;
    }

    public int getLeagueId() {
        return mLeagueId;
    }

    public void setHomeWinUs(int homeWinUs) {
        mHomeWinUs = homeWinUs;
    }

    public int getHomeWinUs() {
        return mHomeWinUs;
    }

    public void setHomeUnifiedComments(List<String> homeUnifiedComments) {
        mHomeUnifiedComments = homeUnifiedComments;
    }

    public List<String> getHomeUnifiedComments() {
        return mHomeUnifiedComments;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }

    public void setLeagueName(String leagueName) {
        mLeagueName = leagueName;
    }

    public String getLeagueName() {
        return mLeagueName;
    }

    public void setHomeScoredAtVenue(int homeScoredAtVenue) {
        mHomeScoredAtVenue = homeScoredAtVenue;
    }

    public int getHomeScoredAtVenue() {
        return mHomeScoredAtVenue;
    }

    public void setLastMatches(List<LastMatch> lastMatches) {
        mLastMatches = lastMatches;
    }

    public List<LastMatch> getLastMatches() {
        return mLastMatches;
    }

    public void setAwayGoalsCharts(List<AwayGoalsChart> awayGoalsCharts) {
        mAwayGoalsCharts = awayGoalsCharts;
    }

    public List<AwayGoalsChart> getAwayGoalsCharts() {
        return mAwayGoalsCharts;
    }

    public void setAwayTeamId(int awayTeamId) {
        mAwayTeamId = awayTeamId;
    }

    public int getAwayTeamId() {
        return mAwayTeamId;
    }

    public void setHomeGoalsCharts(List<HomeGoalsChart> homeGoalsCharts) {
        mHomeGoalsCharts = homeGoalsCharts;
    }

    public List<HomeGoalsChart> getHomeGoalsCharts() {
        return mHomeGoalsCharts;
    }

    public void setPicks(List<Pick> picks) {
        mPicks = picks;
    }

    public List<Pick> getPicks() {
        return mPicks;
    }

    public void setScoreGoalsCharts(List<ScoreGoalsChart> scoreGoalsCharts) {
        mScoreGoalsCharts = scoreGoalsCharts;
    }

    public List<ScoreGoalsChart> getScoreGoalsCharts() {
        return mScoreGoalsCharts;
    }

    public void setHomeGoal(int homeGoal) {
        mHomeGoal = homeGoal;
    }

    public int getHomeGoal() {
        return mHomeGoal;
    }

    public void setConsensus(List<Consensus> consensus) {
        mConsensus = consensus;
    }

    public List<Consensus> getConsensus() {
        return mConsensus;
    }

    public void setSeason(int season) {
        mSeason = season;
    }

    public int getSeason() {
        return mSeason;
    }

    public void setDraw(int draw) {
        mDraw = draw;
    }

    public int getDraw() {
        return mDraw;
    }

    public void setAwayGoal(int awayGoal) {
        mAwayGoal = awayGoal;
    }

    public int getAwayGoal() {
        return mAwayGoal;
    }

    public void setAwayMlineAccuracy(int awayMlineAccuracy) {
        mAwayMlineAccuracy = awayMlineAccuracy;
    }

    public int getAwayMlineAccuracy() {
        return mAwayMlineAccuracy;
    }

    public void setBothTeamsToScores(List<BothTeamsToScore> bothTeamsToScores) {
        mBothTeamsToScores = bothTeamsToScores;
    }

    public List<BothTeamsToScore> getBothTeamsToScores() {
        return mBothTeamsToScores;
    }

    public void setDate(Long date) {
        mDate = date;
    }

    public Long getDate() {
        return mDate;
    }

    public void setAwayTeamName(String awayTeamName) {
        mAwayTeamName = awayTeamName;
    }

    public String getAwayTeamName() {
        return mAwayTeamName;
    }

    public void setAwayWinsAtVenue(int awayWinsAtVenue) {
        mAwayWinsAtVenue = awayWinsAtVenue;
    }

    public int getAwayWinsAtVenue() {
        return mAwayWinsAtVenue;
    }

    public void setHistoricalRecordsDatum(HistoricalRecordsDatum historicalRecordsDatum) {
        mHistoricalRecordsDatum = historicalRecordsDatum;
    }

    public HistoricalRecordsDatum getHistoricalRecordsDatum() {
        return mHistoricalRecordsDatum;
    }

    public void setHomeTeamName(String homeTeamName) {
        mHomeTeamName = homeTeamName;
    }

    public String getHomeTeamName() {
        return mHomeTeamName;
    }

    public void setMlineOdds(List<MlineOdd> mlineOdds) {
        mMlineOdds = mlineOdds;
    }

    public List<MlineOdd> getMlineOdds() {
        return mMlineOdds;
    }

    public void setHotGame(int hotGame) {
        mHotGame = hotGame;
    }

    public int getHotGame() {
        return mHotGame;
    }

    public void setOddsTables(List<OddsTable> oddsTables) {
        mOddsTables = oddsTables;
    }

    public List<OddsTable> getOddsTables() {
        return mOddsTables;
    }

    public void setSpreadPredictions(List<SpreadPrediction> spreadPredictions) {
        mSpreadPredictions = spreadPredictions;
    }

    public List<SpreadPrediction> getSpreadPredictions() {
        return mSpreadPredictions;
    }

    public void setHomeStatComments(List<String> homeStatComments) {
        mHomeStatComments = homeStatComments;
    }

    public List<String> getHomeStatComments() {
        return mHomeStatComments;
    }

    public void setAwayRankings(List<AwayRanking> awayRankings) {
        mAwayRankings = awayRankings;
    }

    public List<AwayRanking> getAwayRankings() {
        return mAwayRankings;
    }

    public void setHomeWin(int homeWin) {
        mHomeWin = homeWin;
    }

    public int getHomeWin() {
        return mHomeWin;
    }

    public void setLineMoves(List<LineMove> lineMoves) {
        mLineMoves = lineMoves;
    }

    public List<LineMove> getLineMoves() {
        return mLineMoves;
    }

    public void setAwayIndex(double awayIndex) {
        mAwayIndex = awayIndex;
    }

    public double getAwayIndex() {
        return mAwayIndex;
    }

    public void setHomeRankings(List<HomeRanking> homeRankings) {
        mHomeRankings = homeRankings;
    }

    public List<HomeRanking> getHomeRankings() {
        return mHomeRankings;
    }

    public void setTotalGoalsPredictions(List<TotalGoalsPrediction> totalGoalsPredictions) {
        mTotalGoalsPredictions = totalGoalsPredictions;
    }

    public List<TotalGoalsPrediction> getTotalGoalsPredictions() {
        return mTotalGoalsPredictions;
    }

    public void setAwayScoredAtVenue(int awayScoredAtVenue) {
        mAwayScoredAtVenue = awayScoredAtVenue;
    }

    public int getAwayScoredAtVenue() {
        return mAwayScoredAtVenue;
    }

    public void setHomeMlineAccuracy(int homeMlineAccuracy) {
        mHomeMlineAccuracy = homeMlineAccuracy;
    }

    public int getHomeMlineAccuracy() {
        return mHomeMlineAccuracy;
    }

    public void setTour(int tour) {
        mTour = tour;
    }

    public int getTour() {
        return mTour;
    }

    public void setJcGame(int jcGame) {
        mJcGame = jcGame;
    }

    public int getJcGame() {
        return mJcGame;
    }

    public void setHomeTeamId(int homeTeamId) {
        mHomeTeamId = homeTeamId;
    }

    public int getHomeTeamId() {
        return mHomeTeamId;
    }

    public void setDrawUs(int drawUs) {
        mDrawUs = drawUs;
    }

    public int getDrawUs() {
        return mDrawUs;
    }

    public void setTeamsLeaguePositions(List<TeamsLeaguePosition> teamsLeaguePositions) {
        mTeamsLeaguePositions = teamsLeaguePositions;
    }

    public List<TeamsLeaguePosition> getTeamsLeaguePositions() {
        return mTeamsLeaguePositions;
    }

    public void setResult(Result result) {
        mResult = result;
    }

    public Result getResult() {
        return mResult;
    }

    public void setSpreadOdds(List<SpreadOdd> spreadOdds) {
        mSpreadOdds = spreadOdds;
    }

    public List<SpreadOdd> getSpreadOdds() {
        return mSpreadOdds;
    }

    public void setHomeAvgs(List<HomeAvg> homeAvgs) {
        mHomeAvgs = homeAvgs;
    }

    public List<HomeAvg> getHomeAvgs() {
        return mHomeAvgs;
    }

    public void setAwayWinUs(int awayWinUs) {
        mAwayWinUs = awayWinUs;
    }

    public int getAwayWinUs() {
        return mAwayWinUs;
    }

    public void setAwayWin(int awayWin) {
        mAwayWin = awayWin;
    }

    public int getAwayWin() {
        return mAwayWin;
    }

    public void setCurrentForm(CurrentForm currentForm) {
        mCurrentForm = currentForm;
    }

    public CurrentForm getCurrentForm() {
        return mCurrentForm;
    }

    public void setAwayStatComments(List<String> awayStatComments) {
        mAwayStatComments = awayStatComments;
    }

    public List<String> getAwayStatComments() {
        return mAwayStatComments;
    }

    public void setHomeIndex(double homeIndex) {
        mHomeIndex = homeIndex;
    }

    public double getHomeIndex() {
        return mHomeIndex;
    }

    public void setHomeWinsAtVenue(int homeWinsAtVenue) {
        mHomeWinsAtVenue = homeWinsAtVenue;
    }

    public int getHomeWinsAtVenue() {
        return mHomeWinsAtVenue;
    }

    public void setProbabilityToWins(List<ProbabilityToWin> probabilityToWins) {
        mProbabilityToWins = probabilityToWins;
    }

    public List<ProbabilityToWin> getProbabilityToWins() {
        return mProbabilityToWins;
    }

    public void setWinToNils(List<WinToNil> winToNils) {
        mWinToNils = winToNils;
    }

    public List<WinToNil> getWinToNils() {
        return mWinToNils;
    }

    public void setAwayAvgs(List<AwayAvg> awayAvgs) {
        mAwayAvgs = awayAvgs;
    }

    public List<AwayAvg> getAwayAvgs() {
        return mAwayAvgs;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof GameDetail){
            return ((GameDetail) obj).getId() == mId;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return ((Long)mId).hashCode();
    }

    public GameDetail(Parcel in) {
        mState = in.readInt() == 1 ? true: false;
        mMessage = in.readString();
        mError = in.readString();
        mOuOdds = new ArrayList<OuOdd>();
        in.readTypedList(mOuOdds, OuOdd.CREATOR);
        mLocation = in.readString();
        in.readArrayList(String.class.getClassLoader());
        mLeagueId = in.readInt();
        mHomeWinUs = in.readInt();
        in.readArrayList(String.class.getClassLoader());
        mId = in.readLong();
        mLeagueName = in.readString();
        mHomeScoredAtVenue = in.readInt();
        mLastMatches = new ArrayList<LastMatch>();
        in.readTypedList(mLastMatches, LastMatch.CREATOR);
        mAwayGoalsCharts = new ArrayList<AwayGoalsChart>();
        in.readTypedList(mAwayGoalsCharts, AwayGoalsChart.CREATOR);
        mAwayTeamId = in.readInt();
        mHomeGoalsCharts = new ArrayList<HomeGoalsChart>();
        in.readTypedList(mHomeGoalsCharts, HomeGoalsChart.CREATOR);
        mPicks = new ArrayList<Pick>();
        in.readTypedList(mPicks, Pick.CREATOR);
        mScoreGoalsCharts = new ArrayList<ScoreGoalsChart>();
        in.readTypedList(mScoreGoalsCharts, ScoreGoalsChart.CREATOR);
        mHomeGoal = in.readInt();
        mConsensus = new ArrayList<Consensus>();
        in.readTypedList(mConsensus, Consensus.CREATOR);
        mSeason = in.readInt();
        mDraw = in.readInt();
        mAwayGoal = in.readInt();
        mAwayMlineAccuracy = in.readInt();
        mBothTeamsToScores = new ArrayList<BothTeamsToScore>();
        in.readTypedList(mBothTeamsToScores, BothTeamsToScore.CREATOR);
        mDate = in.readLong();
        mAwayTeamName = in.readString();
        mAwayWinsAtVenue = in.readInt();
        mHistoricalRecordsDatum = in.readParcelable(HistoricalRecordsDatum.class.getClassLoader());
        mHomeTeamName = in.readString();
        mMlineOdds = new ArrayList<MlineOdd>();
        in.readTypedList(mMlineOdds, MlineOdd.CREATOR);
        mHotGame = in.readInt();
        mOddsTables = new ArrayList<OddsTable>();
        in.readTypedList(mOddsTables, OddsTable.CREATOR);
        mSpreadPredictions = new ArrayList<SpreadPrediction>();
        in.readTypedList(mSpreadPredictions, SpreadPrediction.CREATOR);
        in.readArrayList(String.class.getClassLoader());
        mAwayRankings = new ArrayList<AwayRanking>();
        in.readTypedList(mAwayRankings, AwayRanking.CREATOR);
        mHomeWin = in.readInt();
        mLineMoves = new ArrayList<LineMove>();
        in.readTypedList(mLineMoves, LineMove.CREATOR);
        mAwayIndex = in.readInt();
        mHomeRankings = new ArrayList<HomeRanking>();
        in.readTypedList(mHomeRankings, HomeRanking.CREATOR);
        mTotalGoalsPredictions = new ArrayList<TotalGoalsPrediction>();
        in.readTypedList(mTotalGoalsPredictions, TotalGoalsPrediction.CREATOR);
        mAwayScoredAtVenue = in.readInt();
        mHomeMlineAccuracy = in.readInt();
        mTour = in.readInt();
        mJcGame = in.readInt();
        mHomeTeamId = in.readInt();
        mDrawUs = in.readInt();
        mTeamsLeaguePositions = new ArrayList<TeamsLeaguePosition>();
        in.readTypedList(mTeamsLeaguePositions, TeamsLeaguePosition.CREATOR);
        mResult = in.readParcelable(Result.class.getClassLoader());
        mSpreadOdds = new ArrayList<SpreadOdd>();
        in.readTypedList(mSpreadOdds, SpreadOdd.CREATOR);
        mHomeAvgs = new ArrayList<HomeAvg>();
        in.readTypedList(mHomeAvgs, HomeAvg.CREATOR);
        mAwayWinUs = in.readInt();
        mAwayWin = in.readInt();
        mCurrentForm = in.readParcelable(CurrentForm.class.getClassLoader());
        in.readArrayList(String.class.getClassLoader());
        mHomeIndex = in.readDouble();
        mHomeWinsAtVenue = in.readInt();
        mProbabilityToWins = new ArrayList<ProbabilityToWin>();
        in.readTypedList(mProbabilityToWins, ProbabilityToWin.CREATOR);
        mWinToNils = new ArrayList<WinToNil>();
        in.readTypedList(mWinToNils, WinToNil.CREATOR);
        mAwayAvgs = new ArrayList<AwayAvg>();
        in.readTypedList(mAwayAvgs, AwayAvg.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GameDetail> CREATOR = new Creator<GameDetail>() {
        public GameDetail createFromParcel(Parcel in) {
            return new GameDetail(in);
        }

        public GameDetail[] newArray(int size) {
        return new GameDetail[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mState ? 1 : 0);
        dest.writeString(mMessage);
        dest.writeString(mError);
        dest.writeTypedList(mOuOdds);
        dest.writeString(mLocation);
        dest.writeList(mAwayUnifiedComments);
        dest.writeInt(mLeagueId);
        dest.writeInt(mHomeWinUs);
        dest.writeList(mHomeUnifiedComments);
        dest.writeLong(mId);
        dest.writeString(mLeagueName);
        dest.writeInt(mHomeScoredAtVenue);
        dest.writeTypedList(mLastMatches);
        dest.writeTypedList(mAwayGoalsCharts);
        dest.writeInt(mAwayTeamId);
        dest.writeTypedList(mHomeGoalsCharts);
        dest.writeTypedList(mPicks);
        dest.writeTypedList(mScoreGoalsCharts);
        dest.writeInt(mHomeGoal);
        dest.writeTypedList(mConsensus);
        dest.writeInt(mSeason);
        dest.writeInt(mDraw);
        dest.writeInt(mAwayGoal);
        dest.writeInt(mAwayMlineAccuracy);
        dest.writeTypedList(mBothTeamsToScores);
        dest.writeLong(mDate);
        dest.writeString(mAwayTeamName);
        dest.writeInt(mAwayWinsAtVenue);
        dest.writeParcelable(mHistoricalRecordsDatum, flags);
        dest.writeString(mHomeTeamName);
        dest.writeTypedList(mMlineOdds);
        dest.writeInt(mHotGame);
        dest.writeTypedList(mOddsTables);
        dest.writeTypedList(mSpreadPredictions);
        dest.writeList(mHomeStatComments);
        dest.writeTypedList(mAwayRankings);
        dest.writeInt(mHomeWin);
        dest.writeTypedList(mLineMoves);
        dest.writeDouble(mAwayIndex);
        dest.writeTypedList(mHomeRankings);
        dest.writeTypedList(mTotalGoalsPredictions);
        dest.writeInt(mAwayScoredAtVenue);
        dest.writeInt(mHomeMlineAccuracy);
        dest.writeInt(mTour);
        dest.writeInt(mJcGame);
        dest.writeInt(mHomeTeamId);
        dest.writeInt(mDrawUs);
        dest.writeTypedList(mTeamsLeaguePositions);
        dest.writeParcelable(mResult, flags);
        dest.writeTypedList(mSpreadOdds);
        dest.writeTypedList(mHomeAvgs);
        dest.writeInt(mAwayWinUs);
        dest.writeInt(mAwayWin);
        dest.writeParcelable(mCurrentForm, flags);
        dest.writeList(mAwayStatComments);
        dest.writeDouble(mHomeIndex);
        dest.writeInt(mHomeWinsAtVenue);
        dest.writeTypedList(mProbabilityToWins);
        dest.writeTypedList(mWinToNils);
        dest.writeTypedList(mAwayAvgs);
    }


}