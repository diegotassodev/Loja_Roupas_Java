package loja.drawer;

import java.net.URL;
import loja.abas.administrativas.TabelaClientes;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import loja.main.Main;
import raven.swing.AvatarIcon;
import loja.tabbed.WindowsTabbed;

public class MyDrawerBuilder extends SimpleDrawerBuilder {
    
    // Header do Drawer
    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
                
                // Colocando as informações principais no header
                .setIcon(new AvatarIcon(getClass().getResource("/loja/imagens/profile.png"), 60, 60, 999))
                .setTitle("Área do Administrador")
                .setDescription("Área dos responsáveis técnicos do sistema.");
    }
    
    // Opcões do Drawer
    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        
       // Criando as opções do menu administrativo
       String menus[][] = {
            {"~MENU PRINCIPAL~"},
            {"Tabela de Roupas"},
            {"Tabela de Usuários"},
            {"Logout"}
        };
       
       // Retornando a classe de geração do menu e criando suas ações para com a abertura de cada aba.
        return new SimpleMenuOption()
                .setMenus(menus)
                .setBaseIconPath("/loja/icones/icon.svg")
                .addMenuEvent(new MenuEvent() {
                    @Override
                    public void selected(MenuAction action, int index, int subIndex) {
                        
                        // No caso da seleção da opção "Tabela de Roupas", ele abre a tabela de roupas.
                        if (index == 0) {
                            
                        } 
                        
                        // No caso da seleção da opção "Tabela de Usuários", ele abre a tabela de usuários.
                        if (index == 1) {
                            WindowsTabbed.getInstance().addTab("Tabela de Usuários", new TabelaClientes());
                        } 
                        
                        // No caso da opção de Logout, ele retorna para o formulário de Login.
                        else if (index == 2) { 
                            Main.main.login();
                        }
                        System.out.println("Menu selected " + index + " " + subIndex);
                    }
                })
                .setMenuValidation(new MenuValidation() {
                    @Override
                    public boolean menuValidation(int index, int subIndex) {
                        return true;
                    }
                });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData();
    }

    @Override
    public int getDrawerWidth() {
        return 275;
    }
}

