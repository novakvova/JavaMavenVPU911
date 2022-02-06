import "cropperjs/dist/cropper.min.css";
import * as React from "react";
import axios from "axios";
import { Modal, Button, Upload, message,  Row, Col } from 'antd';
import { UploadOutlined } from '@ant-design/icons';
import Cropper from "cropperjs";

//import http from "../../../http_common";

const UsersListPage : React.FC =() => {

    // React.useEffect(() => {
    //     console.log("begin");
    //     axios.get("http://localhost:8085/admin/roles").then((resp)=>console.log(resp));
    // },[]);
    const imgRef = React.useRef<HTMLImageElement>(null);
    const prevRef = React.useRef<HTMLImageElement>(null);
    const [cropperObj, setCropperObj] = React.useState<Cropper>();
    const [visible, setVisible] = React.useState(false);


    const handleChangeFile = async (e: any) => {
      const file = (e.target.files as FileList)[0];
      if (file) {
        const url = URL.createObjectURL(file);
         
        await setVisible(true);
        let cropper= cropperObj;
        if (!cropper) {
          cropper = new Cropper(imgRef.current as HTMLImageElement, {
            aspectRatio: 1 / 1,
            viewMode: 1,
            preview: prevRef.current as HTMLImageElement,
          });
        }
        cropper?.replace(url);
        setCropperObj(cropper);
      }
    };


    const handleCropped = async () => {
        const base64 = cropperObj?.getCroppedCanvas().toDataURL() as string;
        console.log("base64", base64);
        setVisible(false);
    }


    return (
      <>
        <h1>Список користувачів</h1>
        {/* <Button type="primary" onClick={handleShow}>
          Редагування фото
        </Button> */}
        {/* <Upload {...props}>
            <Button icon={<UploadOutlined />}>Click to Upload</Button>
        </Upload> */}
         <input
          id="uploadimg"
          className="d-none"
          type="file"
          onChange={handleChangeFile}
        />

        <Modal
          title="Обробка фото"
          centered
          visible={visible}
          onOk={handleCropped}
          onCancel={() => setVisible(false)}
          width={1000}
          maskClosable={false}
        >
          <Row gutter={[8,8]}>
              <Col md={18} xs={24}>
                  <div>
                      <img src="https://vovalohika.tk/images/1200_431btv0l.ykj.jpeg"
                        ref={imgRef} 
                        width="100%" />
                  </div>
              </Col>
              <Col md={6} xs={24}>
              <div
                    ref = {prevRef}
                    style={{
                        height: "150px",
                        border: "1px solid silver",
                        overflow: "hidden"
                    }}>
                </div>
              </Col>
          </Row>
        </Modal>
      </>
    ); 
}
export default UsersListPage;