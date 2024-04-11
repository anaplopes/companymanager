###
# Docker section
###
.PHONY: dk-prune
dk-prune: ## clean docker
	@docker system prune --all --force --volumes

.PHONY: dk-up-db ## up service db
dk-up-db:
	@docker compose up -d db

.PHONY: dk-up ## up all services
dk-up:
	@docker compose up --build -d

.PHONY: dk-down ## down all services
dk-down:
	@docker compose down --remove-orphans -v
