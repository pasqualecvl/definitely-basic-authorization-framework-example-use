package it.pasqualecavallo.studentsmaterial.authorization_framework_example.visitors;

import org.springframework.stereotype.Component;

import it.pasqualecavallo.studentsmaterial.authorization_framework.security.RoleVisitor;

@Component
public class HierarchicalRoleVisitor extends RoleVisitor {

	@Override
	protected boolean isRoleInternalHierarchicallyUpperOrEqualsTo(String requiredRole, String userRoles) {
		switch(requiredRole) {
		case "ROLE_USER":
			return "ROLE_USER".equals(userRoles) || "ROLE_MODERATOR".equals(userRoles) || "ROLE_ADMIN".equals(userRoles) || "ROLE_SUPERADMIN".equals(userRoles);
		case "ROLE_MODERATOR":
			return "ROLE_MODERATOR".equals(userRoles) || "ROLE_ADMIN".equals(userRoles) || "ROLE_SUPERADMIN".equals(userRoles);
		case "ROLE_ADMIN":
			return "ROLE_ADMIN".equals(userRoles) || "ROLE_SUPERADMIN".equals(userRoles);
		case "ROLE_SUPERADMIN":
			return "ROLE_SUPERADMIN".equals(userRoles);
		default:
			return false;
		}
	}

}
