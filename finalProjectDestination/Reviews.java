package finalProjectDestination;

public class Reviews {
	public double starRating;
	public int reviewsCount;
	
	public Reviews(double starRating, int reviewsCount) {
		this.starRating = starRating;
		this.reviewsCount = reviewsCount;
	}

	public double getStarRating() {
		return starRating;
	}

	public void setStarRating(double starRating) {
		this.starRating = starRating;
	}

	public int getReviewsCount() {
		return reviewsCount;
	}

	public void setReviewsCount(int reviewsCount) {
		this.reviewsCount = reviewsCount;
	}
    public String toString() {
        return "Reviews:" +
               "\n   Star Rating: " + starRating +
               "\n   Reviews Count: " + reviewsCount;
    }
}
