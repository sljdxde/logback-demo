package domain.factory;


import commend.LogCommend;

public class LoggerPolicyContext {
    private ILoggerPolicy policy;

    public static ILoggerPolicy getPolicy(LogCommend commend) {
        String name = commend.getName();
        switch (name.toLowerCase()) {
            case "tenanta":
                return new TenantALogger();
            case "tenantb":
                return new TenantBLogger();
            default:
                return new DefaultLogger();
        }
    }
}
