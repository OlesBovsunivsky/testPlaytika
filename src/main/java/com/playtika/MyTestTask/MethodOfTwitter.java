package com.playtika.MyTestTask;

import org.apache.log4j.Logger;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

public class MethodOfTwitter {

    private static final Logger LOGGER = Logger.getLogger(MethodOfTwitter.class);

    private TwitterFactory twitterFactory = new TwitterFactory(Access.getInstance().
            getAccessToTwitterApp().build());

    private twitter4j.Twitter twitter = twitterFactory.getInstance();

    /**
     * The timeline returned is the equivalent of the one seen when you view a user’s profile on twitter.com.
     * @return a collection of the most recent Tweets posted by the user
     */
    private List<Status> userTimeline() {

        List<Status> list = null;

        try {
            list = twitter.getUserTimeline();
        } catch (TwitterException e) {
            LOGGER.error(e);
        }

        return list;
    }

    public List<Status> getUserTimeLine() {
        return userTimeline();
    }

    /**
     * Sends a new direct message to the specified user from the authenticating user.
     * Requires both the user and text parameters and must be a POST.
     * @param idUser - id user who sent message
     * @param massage - the message to the user
     * @return true if message send to user
     */
    private boolean sendDirectMessage(long idUser, String massage) {

        try {
            twitter.sendDirectMessage(idUser, massage);
            return true;
        } catch (TwitterException e) {
            LOGGER.error(e);
            return false;
        }
    }

    public boolean getSendDirectMessage(long idUser, String massage) {
        return sendDirectMessage(idUser, massage);
    }

    /**
     *
     * @return Returns collection of the 20 most
     * recent direct messages sent to the authenticating user.
     * Includes detailed information about the sender and recipient user.
     */
    private ResponseList directMessage() {

        ResponseList responseList = null;

        try {
            responseList = twitter.getDirectMessages();
            return responseList;
        } catch (TwitterException e) {
            LOGGER.error(e);
            return responseList;
        }
    }

    public ResponseList getDirectMessage(){
        return directMessage();
    }

    /**
     * Updates the authenticating user’s current status, also known as Tweeting.
     * @param mesageStatus - new status of user. The status should be unique each time
     * @return true if status update
     */
    private boolean myStatusUpdate(String mesageStatus){
        try {
            twitter.updateStatus(mesageStatus);
            return true;
        } catch (TwitterException e) {
            LOGGER.error(e);
            return false;
        }
    }

    public boolean getMyStatusUpdate(String mesageStatus){
        return myStatusUpdate(mesageStatus);
    }

    /**
     * Sets some values that users are able to set under the “Account” tab of their settings page. \
     * Only the parameters specified will be updated.
     * @param name
     * @param url
     * @param location
     * @param description
     * @return true if profile update
     */
    private boolean myUpdateProfile(String name,
                                    String url,
                                    String location,
                                    String description){
        try {
            twitter.updateProfile(name, url, location, description);
            return true;
        } catch (TwitterException e) {
            LOGGER.error(e);
            return false;
        }
    }

    public boolean getMyUpdateProfile(String name,
                                      String url,
                                      String location,
                                      String description){
        return myUpdateProfile(name, url, location, description);
    }

}
