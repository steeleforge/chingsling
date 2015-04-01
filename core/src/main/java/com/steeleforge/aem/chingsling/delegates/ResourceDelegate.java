package com.steeleforge.aem.chingsling.delegates;

import java.util.Optional;
import java.util.stream.Stream;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

public enum ResourceDelegate {
	INSTANCE;
	
	public static final Optional<String> getPath(Resource resource) {
		if (null == resource) {
			return Optional.empty();
		}
		return Optional.ofNullable(resource.getPath());
	}
	
	public static final Optional<String> getName(Resource resource) {
		if (null == resource) {
			return Optional.empty();
		}
		return Optional.ofNullable(resource.getName());
	}
	
	public static final Optional<Resource> getParent(Resource resource) {
		if (null == resource) {
			return Optional.empty();
		}
		return Optional.ofNullable(resource.getParent());
	}

	public static final Stream<Resource> listChildren(Resource resource) {
		if (null == resource) {
			return Stream.empty();
		}
		return ResourceResolverDelegate.listChildren(resource.getResourceResolver()
				, resource);
	}
	
	public static final Stream<Resource> getChildren(Resource resource) {
		if (null == resource) {
			return Stream.empty();
		}
		return ResourceResolverDelegate.getChildren(resource.getResourceResolver()
				, resource);
	}
	
	public static final Optional<Resource> getChild(Resource resource, String relPath) {
		if (null == resource) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.getResource(
						resource.getResourceResolver(), relPath);
	}
	
	public static final Optional<String> getResourceType(Resource resource) {
		if (null == resource) {
			return Optional.empty();
		}
		return Optional.ofNullable(resource.getResourceType());
	}

	
	public static final Optional<String> getResourceSuperType(Resource resource) {
		if (null == resource) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.getParentResourceType(resource.getResourceResolver(), resource);
	}
	
	public static final Optional<ResourceMetadata> getResourceMetadata(Resource resource) {
		if (null == resource) {
			return Optional.empty();
		}
		return Optional.ofNullable(resource.getResourceMetadata());
	}

	
	public static final Optional<ResourceResolver> getResourceResolver(Resource resource) {
		if (null == resource) {
			return Optional.empty();
		}
		return Optional.ofNullable(resource.getResourceResolver());
	}

	
	public static final Optional<ValueMap> getValueMap(Resource resource) {
		if (null == resource) {
			return Optional.empty();
		}
		return Optional.ofNullable(resource.getValueMap());
	}
}
