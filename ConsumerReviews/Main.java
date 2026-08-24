package ConsumerReviews;

public class Main {
    public static void main(String[] args){

// //all my positive reviews had positive values, however my two highest were both negative reviews. I believe that this is because the reviewers were comparing the service to the one they wanted - using positive words to contrast their expeirience. The most positively ranked review talked about how the xpierience was not good for a birthday or celebration, which are both very positive words. I saw a wide range from around 28 to -9
// System.out.println(Review.totalSentiment("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/decentlyNegative.txt"));
// System.out.println(Review.totalSentiment("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/kindaNegative.txt"));
// System.out.println(Review.totalSentiment("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/negative.txt"));
// System.out.println(Review.totalSentiment("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/prettyNegative.txt"));
// System.out.println(Review.totalSentiment("//Users/gracebrowne/Desktop/CSA/ConsumerReviews/shortPositive.txt"));
// System.out.println(Review.totalSentiment("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/somewhatNegative.txt"));
// System.out.println(Review.totalSentiment("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/somewhatPositive.txt"));
// System.out.println(Review.totalSentiment("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/somewhatPositive2.txt"));
// System.out.println(Review.totalSentiment("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/veryNegative.txt"));
// System.out.println(Review.totalSentiment("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/veryPositive.txt"));

// //based on the totalSentiment, these ratings do make sense. However, the totalSentiment rankings are skewed because of the specific reviews 
// //I chose.
// System.out.println(Review.starRating("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/decentlyNegative.txt"));
// System.out.println(Review.starRating("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/kindaNegative.txt"));
// System.out.println(Review.starRating("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/negative.txt"));
// System.out.println(Review.starRating("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/prettyNegative.txt"));
// System.out.println(Review.starRating("//Users/gracebrowne/Desktop/CSA/ConsumerReviews/shortPositive.txt"));
// System.out.println(Review.starRating("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/somewhatNegative.txt"));
// System.out.println(Review.starRating("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/somewhatPositive.txt"));
// System.out.println(Review.starRating("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/somewhatPositive2.txt"));
// System.out.println(Review.starRating("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/veryNegative.txt"));
// System.out.println(Review.starRating("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/veryPositive.txt"));

System.out.println(Review.fakeReview("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/shortPositive.txt"));
// Review.fakeReview("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/shortPositive.txt");
Review.strongerReview("/Users/gracebrowne/Desktop/CSA/ConsumerReviews/shortPositive.txt");
    }
}
