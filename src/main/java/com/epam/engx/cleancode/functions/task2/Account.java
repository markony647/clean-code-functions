package com.epam.engx.cleancode.functions.task2;


import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Level;
import com.epam.engx.cleancode.functions.task2.thirdpartyjar.NotActiveUserException;
import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Review;
import com.epam.engx.cleancode.functions.task2.thirdpartyjar.User;

import java.util.List;
import java.util.TreeMap;

public abstract class Account implements User {

    private TreeMap<Integer, Level> levelMap = new TreeMap<>();

    public Level getActivityLevel() {
        validateAccountForLevel();
        int answersCount = countAllAnswers(getAllReviews());
        return getLevelByAnswersCount(answersCount);
    }

    private int countAllAnswers(List<Review> reviews) {
        int answersCount = 0;
        for (Review currentReview : reviews) {
            answersCount += countAnswers(currentReview);
        }
        return answersCount;
    }

    private int countAnswers(Review review) {
        return review.getAnswers().size();
    }

    private void validateAccountForLevel() {
        validateIfRegistered();
        validateIfHasVisits();
    }

    private void validateIfRegistered() {
        if (!isRegistered()) {
            throw new NotActiveUserException();
        }
    }

    private void validateIfHasVisits() {
        if (getVisitNumber() == 0) {
            throw new NotActiveUserException();
        }
    }

    private Level getLevelByAnswersCount(int reviewAnswersCount) {
        for (Integer threshold : levelMap.keySet()) {
            if (countMatchesThreshold(reviewAnswersCount, threshold)) {
                return getLevelFor(threshold);
            }
        }

        return Level.defaultLevel();
    }

    private Level getLevelFor(Integer threshold) {
        return levelMap.get(threshold);
    }

    private boolean countMatchesThreshold(int reviewAnswersCount, int threshold) {
        return reviewAnswersCount >= threshold;
    }

    public void setLevelMap(TreeMap<Integer, Level> levelMap) {
        this.levelMap = levelMap;
    }
}
