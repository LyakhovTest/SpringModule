package model;

public class TicketImpl implements Ticket{
    private long id;
    private long eventId;
    private long userId;
    private Category category;
    private int place;

    public TicketImpl(long id, long eventId, long userId, Category category, int place) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.category = category;
        this.place = place;
    }

    @Override
    public String toString() {
        return "TicketImpl{" +
                "id=" + id +
                ", eventId=" + eventId +
                ", userId=" + userId +
                ", category=" + category +
                ", place=" + place +
                '}';
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {

    }

    @Override
    public long getEventId() {
        return 0;
    }

    @Override
    public void setEventId(long eventId) {

    }

    @Override
    public long getUserId() {
        return 0;
    }

    @Override
    public void setUserId(long userId) {

    }

    @Override
    public Category getCategory() {
        return null;
    }

    @Override
    public void setCategory(Category category) {

    }

    @Override
    public int getPlace() {
        return 0;
    }

    @Override
    public void setPlace(int place) {

    }
}