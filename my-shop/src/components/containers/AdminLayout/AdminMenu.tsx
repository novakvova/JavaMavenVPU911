import * as React from 'react';
import { Layout, Menu, Breadcrumb } from 'antd';
import { UserOutlined, LaptopOutlined, NotificationOutlined, 
    LeftOutlined, RightOutlined } from '@ant-design/icons';
// import { MenuClickEventHandler } from 'rc-menu/lib/interface' ;


const AdminMenu : React.FC= () => {
    const { SubMenu } = Menu;
    const {  Sider } = Layout;
  
    const [collapsed, setCollapsed] = React.useState(false);
  
    const  onCollapse = (collapsed : boolean) => {
      setCollapsed(collapsed);
    };

    return (
        <>
         <Sider
                className="site-layout-background"
                width={200}
                collapsed={collapsed}
                onCollapse={onCollapse}
              >
                <Menu
                  mode="inline"
                  defaultSelectedKeys={["1"]}
                  defaultOpenKeys={["sub1"]}
                  style={{ height: "100%" }}
                >
                  <SubMenu key="sub1" icon={<UserOutlined />} title="subnav 1">
                    <Menu.Item key="1">option1</Menu.Item>
                    <Menu.Item key="2">option2</Menu.Item>
                    <Menu.Item key="3">option3</Menu.Item>
                    <Menu.Item key="4">option4</Menu.Item>
                  </SubMenu>
                  <SubMenu
                    key="sub2"
                    icon={<LaptopOutlined />}
                    title="subnav 2"
                  >
                    <Menu.Item key="5">option5</Menu.Item>
                    <Menu.Item key="6">option6</Menu.Item>
                    <Menu.Item key="7">option7</Menu.Item>
                    <Menu.Item key="8">option8</Menu.Item>
                  </SubMenu>
                  <SubMenu
                    key="sub3"
                    icon={<NotificationOutlined />}
                    title="subnav 3"
                  >
                    <Menu.Item key="9">option9</Menu.Item>
                    <Menu.Item key="10">option10</Menu.Item>
                    <Menu.Item key="11">option11</Menu.Item>
                    <Menu.Item key="12">option12</Menu.Item>
                  </SubMenu>
                  <Menu.Item
                    key="13"
                    icon={ collapsed ? <RightOutlined/> : <LeftOutlined />}
                    onClick={(e: any) => { onCollapse(!collapsed); e.preventDefault(); }}
                  >
                  </Menu.Item>
                </Menu>
              </Sider>
        </>
    );
}
export default AdminMenu;