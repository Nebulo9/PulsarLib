package fr.nebulo9.pulsarlib.request;

import fr.nebulo9.pulsarlib.PulsarLib;
import fr.nebulo9.pulsarlib.task.CounterTask;
import org.bukkit.Bukkit;

import java.util.HashSet;
import java.util.UUID;

public class ActiveRequest {

    private static final HashSet<Request> ACTIVE_REQUESTS = new HashSet<>();

    public static void addRequest(Request request) {
        ACTIVE_REQUESTS.add(request);
        new CounterTask(request.getLiveTime(),() -> handleStatus(request.getRequestId())).runTaskTimer(PulsarLib.getPlugin(),0,20L);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PulsarLib.getPlugin(),() -> {
            UUID requestId = request.getRequestId();
            if(getRequest(requestId) != null) {
                request.setStatus(RequestStatus.EXPIRED);
                handleStatus(requestId);
            }
        },20 * request.getLiveTime());
    }

    public static void removeRequest(UUID requestId) {
        for(Request r : ACTIVE_REQUESTS) {
            if(r.getRequestId().equals(requestId)) {
                ACTIVE_REQUESTS.remove(r);
                return;
            }
        }
    }

    public static Request getRequest(UUID requestId) {
        for(Request r : ACTIVE_REQUESTS) {
            if(r.getRequestId().equals(requestId)) {
                return r;
            }
        }
        return null;
    }

    public static void handleStatus(UUID requestId) {
        RequestStatus status = getRequest(requestId).getStatus();
        if(status != RequestStatus.SENT) {
            removeRequest(requestId);
        }
    }

}
