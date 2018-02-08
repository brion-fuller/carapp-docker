FROM node:9.5.0-alpine

WORKDIR /opt/app/ui

COPY ./package.json ./
COPY ./package-lock.json ./
COPY ./public ./public
COPY ./src ./src

RUN npm install

RUN ls src

ENTRYPOINT [ "npm", "start" ]