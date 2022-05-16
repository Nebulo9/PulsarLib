package fr.nebulo9.pulsarlib.request;

import java.util.UUID;

public class Request {
    private final UUID senderId;

    private final UUID requestId = UUID.randomUUID();

    private final RequestType type;

    private RequestStatus status;

    private final long liveTime;

    public Request(UUID senderId, RequestType type, long liveTime) {
        this.senderId = senderId;
        this.type = type;
        this.liveTime = liveTime;
        status = RequestStatus.SENT;
    }

    public UUID getSenderId() {
        return senderId;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public RequestType getType() {
        return type;
    }

    public long getLiveTime() {
        return liveTime;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public RequestStatus getStatus() {
        return status;
    }
}
