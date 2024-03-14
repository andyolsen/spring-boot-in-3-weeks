package onlineretailer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="resources")
public class ResourcesBean {

    private String db;
    private String logs;
    private boolean secure;

    public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getLogs() {
		return logs;
	}

	public void setLogs(String logs) {
		this.logs = logs;
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	@Override
    public String toString() {
        return String.format("resources.db: %s, resources.logs: %s, resources.secure: %s", db, logs, secure);
    }
}
