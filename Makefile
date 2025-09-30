JAVAC = javac
JAVA = java
SRC_DIR = src
BIN_DIR = bin
MAIN_CLASS = Main


JAVA_FILES = src/model/Content.java src/model/Event.java src/model/FriendRequest.java src/model/Group.java src/model/GroupMessage.java src/model/ImagePost.java src/model/MemberEntity.java src/model/Message.java src/model/Notification.java src/model/Post.java src/model/Privacy.java src/model/TextPost.java src/model/User.java src/model/VideoPost.java src/controller/EventController.java src/controller/FeedController.java src/controller/FriendController.java src/controller/FriendRequestController.java src/controller/GroupChatController.java src/controller/GroupController.java src/controller/MessageController.java src/controller/NotificationController.java src/controller/PostController.java src/controller/UserController.java src/view/SocialAppSwing.java src/Main.java


$(BIN_DIR):
	mkdir -p $(BIN_DIR)


compile: $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) $(JAVA_FILES)
	@echo "✅ Projeto compilado com sucesso!"

compile-wildcards: $(BIN_DIR)
	$(JAVAC) -d $(BIN_DIR) src/model/.java src/controller/.java src/view/*.java src/Main.java
	@echo "✅ Projeto compilado com sucesso usando wildcards!"


run: compile
	$(JAVA) -Djava.awt.headless=false -Dsun.java2d.xrender=false -cp $(BIN_DIR) $(MAIN_CLASS)


run-debug: compile
	$(JAVA) -Djava.awt.headless=false -Dsun.java2d.xrender=false -Dsun.java2d.trace=log -cp $(BIN_DIR) $(MAIN_CLASS)


clean:
	rm -rf $(BIN_DIR)
	@echo "🧹 Arquivos compilados removidos!"


test: compile
	@echo "🧪 Nenhum teste configurado"


help:
	@echo "Comandos disponíveis:"
	@echo "  make -f Makefile.linux compile          - Compila o projeto (lista explícita)"
	@echo "  make -f Makefile.linux compile-wildcards - Compila usando wildcards"
	@echo "  make -f Makefile.linux run              - Compila e executa o projeto"
	@echo "  make -f Makefile.linux run-debug        - Executa com debug gráfico"
	@echo "  make -f Makefile.linux clean            - Remove arquivos compilados"
	@echo "  make -f Makefile.linux test             - Executa testes"
	@echo "  make -f Makefile.linux help             - Mostra esta ajuda"

.PHONY: compile run clean test help
