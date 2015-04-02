package com.steeleforge.aem.chingsling.resource.impl;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.sling.adapter.annotations.Adaptable;
import org.apache.sling.adapter.annotations.Adapter;
import org.apache.sling.api.adapter.SlingAdaptable;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;

import com.steeleforge.aem.chingsling.delegates.ResourceResolverDelegate;
import com.steeleforge.aem.chingsling.resource.ChisourceResolver;

@Adaptable(
		adaptableClass = ChisourceResolver.class,
		adapters = {
			@Adapter({ ResourceResolver.class})
		}
)
@Model(adaptables=Resource.class)
public class ChisourceResolverImpl extends SlingAdaptable implements ChisourceResolver {
	@Inject
	private Resource resource;
	private ResourceResolver resourceResolver;
	
	@SuppressWarnings("unused")
	private ChisourceResolverImpl() {
		if (null != resource) {
			this.resourceResolver = resource.getResourceResolver();
		}
	}
	public ChisourceResolverImpl(ResourceResolver resourceResolver) {
		super();
		if (null == this.resourceResolver) {
			this.resourceResolver = resourceResolver;
		}
	}
	@Override
	public Optional<Resource> resolve(HttpServletRequest request, String absPath) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.resolve(resourceResolver, request, absPath);
	}
	@Override
	public Optional<Resource> resolve(String absPath) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.resolve(resourceResolver, absPath);
	}
	@Override
	public Optional<String> map(String resourcePath) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.map(resourceResolver, resourcePath);
	}
	@Override
	public Optional<String> map(HttpServletRequest request, String resourcePath) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.map(resourceResolver, request, resourcePath);
	}
	@Override
	public Optional<Resource> getResource(String path) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.getResource(resourceResolver, path);
	}
	@Override
	public Optional<Resource> getResource(Resource base, String path) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.getResource(resourceResolver, base, path);
	}
	@Override
	public Optional<String[]> getSearchPath() {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.getSearchPath(resourceResolver);
	}
	@Override
	public Stream<Resource> listChildren(Resource parent) {
		if (null == resourceResolver) {
			return Stream.empty();
		}
		return ResourceResolverDelegate.listChildren(resourceResolver, parent);
	}
	@Override
	public Stream<Resource> getChildren(Resource parent) {
		if (null == resourceResolver) {
			return Stream.empty();
		}
		return ResourceResolverDelegate.getChildren(resourceResolver, parent);
	}
	@Override
	public Stream<Resource> findResources(String query, String language) {
		if (null == resourceResolver) {
			return Stream.empty();
		}
		return ResourceResolverDelegate.findResources(resourceResolver, query, language);
	}
	@Override
	public Stream<Map<String, Object>> queryResources(String query,
			String language) {
		if (null == resourceResolver) {
			return Stream.empty();
		}
		return ResourceResolverDelegate.queryResources(resourceResolver, query, language);
	}
	@Override
	public boolean hasChildren(Resource resource) {
		if (null == resourceResolver) {
			return false;
		}
		return resourceResolver.hasChildren(resource);
	}
	@Override
	public Optional<ResourceResolver> clone(Map<String, Object> authenticationInfo)
			throws LoginException {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.clone(resourceResolver, authenticationInfo);
	}
	@Override
	public boolean isLive() {
		if (null == resourceResolver) {
			return false;
		}
		return resourceResolver.isLive();
	}
	@Override
	public void close() {
		if (null == resourceResolver) {
			return;
		}
		resourceResolver.close();
	}
	@Override
	public Optional<String> getUserID() {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.getUserID(resourceResolver);
	}
	@Override
	public Stream<String> getAttributeNames() {
		if (null == resourceResolver) {
			return Stream.empty();
		}
		return ResourceResolverDelegate.getAttributeNames(resourceResolver);
	}
	@Override
	public Optional<Object> getAttribute(String name) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.getAttribute(resourceResolver, name);
	}
	@Override
	public void delete(Resource resource) throws PersistenceException {
		if (null == resourceResolver) {
			return;
		}
		resourceResolver.delete(resource);
	}
	@Override
	public Optional<Resource> create(Resource parent, String name,
			Map<String, Object> properties) throws PersistenceException {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.create(resourceResolver, parent, name, properties);
	}
	@Override
	public void revert() {
		if (null == resourceResolver) {
			return;
		}
		resourceResolver.revert();
	}
	@Override
	public void commit() throws PersistenceException {
		if (null == resourceResolver) {
			return;
		}
		resourceResolver.commit();
	}
	@Override
	public boolean hasChanges() {
		if (null == resourceResolver) {
			return false;
		}
		return resourceResolver.hasChanges();	
	}
	@Override
	public Optional<String> getParentResourceType(Resource resource) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.getParentResourceType(resourceResolver, resource);
	}
	@Override
	public Optional<String> getParentResourceType(String resourceType) {
		if (null == resourceResolver) {
			return Optional.empty();
		}
		return ResourceResolverDelegate.getParentResourceType(resourceResolver, resourceType);
	}
	@Override
	public boolean isResourceType(Resource resource, String resourceType) {
		if (null == resourceResolver) {
			return false;
		}
		return resourceResolver.isResourceType(resource, resourceType);
	}
	@Override
	public void refresh() {
		if (null == resourceResolver) {
			return;
		}
		resourceResolver.refresh();
	}
}
